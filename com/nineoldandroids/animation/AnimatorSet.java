package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AnimatorSet extends Animator {
    private ArrayList<Animator> mPlayingSet = new ArrayList<>();
    private HashMap<Animator, Node> mNodeMap = new HashMap<>();
    private ArrayList<Node> mNodes = new ArrayList<>();
    private ArrayList<Node> mSortedNodes = new ArrayList<>();
    private boolean mNeedsSort = true;
    private AnimatorSetListener mSetListener = null;
    boolean mTerminated = false;
    private boolean mStarted = false;
    private long mStartDelay = 0;
    private ValueAnimator mDelayAnim = null;
    private long mDuration = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;

        public Dependency(Node node, int i3) {
            this.node = node;
            this.rule = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public ArrayList<Dependency> tmpDependencies = null;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public boolean done = false;

        public Node(Animator animator) {
            this.animation = animator;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList<>();
                this.nodeDependencies = new ArrayList<>();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList<>();
            }
            node.nodeDependents.add(this);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Node m72clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.m71clone();
                return node;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.mNodes.size();
            for (int i3 = 0; i3 < size; i3++) {
                Node node = this.mNodes.get(i3);
                ArrayList<Dependency> arrayList2 = node.dependencies;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(node);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    Node node2 = (Node) arrayList.get(i16);
                    this.mSortedNodes.add(node2);
                    ArrayList<Node> arrayList4 = node2.nodeDependents;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i17 = 0; i17 < size3; i17++) {
                            Node node3 = node2.nodeDependents.get(i17);
                            node3.nodeDependencies.remove(node2);
                            if (node3.nodeDependencies.size() == 0) {
                                arrayList3.add(node3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.mNodes.size();
        for (int i18 = 0; i18 < size4; i18++) {
            Node node4 = this.mNodes.get(i18);
            ArrayList<Dependency> arrayList5 = node4.dependencies;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = node4.dependencies.size();
                for (int i19 = 0; i19 < size5; i19++) {
                    Dependency dependency = node4.dependencies.get(i19);
                    if (node4.nodeDependencies == null) {
                        node4.nodeDependencies = new ArrayList<>();
                    }
                    if (!node4.nodeDependencies.contains(dependency.node)) {
                        node4.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node4.done = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void cancel() {
        ArrayList arrayList;
        this.mTerminated = true;
        if (isStarted()) {
            ArrayList<Animator.AnimatorListener> arrayList2 = this.mListeners;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            } else {
                arrayList = null;
            }
            ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it5 = this.mSortedNodes.iterator();
                while (it5.hasNext()) {
                    it5.next().animation.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    ((Animator.AnimatorListener) it6.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                Iterator<Node> it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    Node next = it.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    next.animation.addListener(this.mSetListener);
                }
            }
            ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it5 = this.mSortedNodes.iterator();
                while (it5.hasNext()) {
                    it5.next().animation.end();
                }
            }
            ArrayList<Animator.AnimatorListener> arrayList = this.mListeners;
            if (arrayList != null) {
                Iterator it6 = ((ArrayList) arrayList.clone()).iterator();
                while (it6.hasNext()) {
                    ((Animator.AnimatorListener) it6.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> arrayList = new ArrayList<>();
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().animation);
        }
        return arrayList;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.mDuration;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.mStartDelay;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isRunning() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (it.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    public Builder play(Animator animator) {
        if (animator != null) {
            this.mNeedsSort = true;
            return new Builder(animator);
        }
        return null;
    }

    public void playSequentially(Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            int i3 = 0;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i3 < animatorArr.length - 1) {
                Builder play = play(animatorArr[i3]);
                i3++;
                play.before(animatorArr[i3]);
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            Builder play = play(animatorArr[0]);
            for (int i3 = 1; i3 < animatorArr.length; i3++) {
                play.with(animatorArr[i3]);
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setInterpolator(Interpolator interpolator) {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setInterpolator(interpolator);
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setStartDelay(long j3) {
        this.mStartDelay = j3;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setTarget(Object obj) {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Animator animator = it.next().animation;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupEndValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupEndValues();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupStartValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupStartValues();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void start() {
        this.mTerminated = false;
        this.mStarted = true;
        sortNodes();
        int size = this.mSortedNodes.size();
        for (int i3 = 0; i3 < size; i3++) {
            Node node = this.mSortedNodes.get(i3);
            ArrayList<Animator.AnimatorListener> listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it = new ArrayList(listeners).iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < size; i16++) {
            Node node2 = this.mSortedNodes.get(i16);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            ArrayList<Dependency> arrayList2 = node2.dependencies;
            if (arrayList2 != null && arrayList2.size() != 0) {
                int size2 = node2.dependencies.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    Dependency dependency = node2.dependencies.get(i17);
                    dependency.node.animation.addListener(new DependencyListener(this, node2, dependency.rule));
                }
                node2.tmpDependencies = (ArrayList) node2.dependencies.clone();
            } else {
                arrayList.add(node2);
            }
            node2.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Node node3 = (Node) it5.next();
                node3.animation.start();
                this.mPlayingSet.add(node3.animation);
            }
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim = ofFloat;
            ofFloat.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new AnimatorListenerAdapter() { // from class: com.nineoldandroids.animation.AnimatorSet.1
                boolean canceled = false;

                @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.canceled = true;
                }

                @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.canceled) {
                        int size3 = arrayList.size();
                        for (int i18 = 0; i18 < size3; i18++) {
                            Node node4 = (Node) arrayList.get(i18);
                            node4.animation.start();
                            AnimatorSet.this.mPlayingSet.add(node4.animation);
                        }
                    }
                }
            });
            this.mDelayAnim.start();
        }
        ArrayList<Animator.AnimatorListener> arrayList3 = this.mListeners;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i18 = 0; i18 < size3; i18++) {
                ((Animator.AnimatorListener) arrayList4.get(i18)).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0) {
            this.mStarted = false;
            ArrayList<Animator.AnimatorListener> arrayList5 = this.mListeners;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i19 = 0; i19 < size4; i19++) {
                    ((Animator.AnimatorListener) arrayList6.get(i19)).onAnimationEnd(this);
                }
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public AnimatorSet m71clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.m71clone();
        animatorSet.mNeedsSort = true;
        animatorSet.mTerminated = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new ArrayList<>();
        animatorSet.mNodeMap = new HashMap<>();
        animatorSet.mNodes = new ArrayList<>();
        animatorSet.mSortedNodes = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Node next = it.next();
            Node m72clone = next.m72clone();
            hashMap.put(next, m72clone);
            animatorSet.mNodes.add(m72clone);
            animatorSet.mNodeMap.put(m72clone.animation, m72clone);
            ArrayList arrayList = null;
            m72clone.dependencies = null;
            m72clone.tmpDependencies = null;
            m72clone.nodeDependents = null;
            m72clone.nodeDependencies = null;
            ArrayList<Animator.AnimatorListener> listeners = m72clone.animation.getListeners();
            if (listeners != null) {
                Iterator<Animator.AnimatorListener> it5 = listeners.iterator();
                while (it5.hasNext()) {
                    Animator.AnimatorListener next2 = it5.next();
                    if (next2 instanceof AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        listeners.remove((Animator.AnimatorListener) it6.next());
                    }
                }
            }
        }
        Iterator<Node> it7 = this.mNodes.iterator();
        while (it7.hasNext()) {
            Node next3 = it7.next();
            Node node = (Node) hashMap.get(next3);
            ArrayList<Dependency> arrayList2 = next3.dependencies;
            if (arrayList2 != null) {
                Iterator<Dependency> it8 = arrayList2.iterator();
                while (it8.hasNext()) {
                    Dependency next4 = it8.next();
                    node.addDependency(new Dependency((Node) hashMap.get(next4.node), next4.rule));
                }
            }
        }
        return animatorSet;
    }

    @Override // com.nineoldandroids.animation.Animator
    public AnimatorSet setDuration(long j3) {
        if (j3 >= 0) {
            Iterator<Node> it = this.mNodes.iterator();
            while (it.hasNext()) {
                it.next().animation.setDuration(j3);
            }
            this.mDuration = j3;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        Builder builder = null;
        for (Animator animator : collection) {
            if (builder == null) {
                builder = play(animator);
            } else {
                builder.with(animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class Builder {
        private Node mCurrentNode;

        Builder(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            this.mCurrentNode = node;
            if (node == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder after(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }

        public Builder before(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }

        public Builder after(long j3) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j3);
            after(ofFloat);
            return this;
        }
    }

    public void playSequentially(List<Animator> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        int i3 = 0;
        if (list.size() == 1) {
            play(list.get(0));
            return;
        }
        while (i3 < list.size() - 1) {
            Builder play = play(list.get(i3));
            i3++;
            play.before(list.get(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class AnimatorSetListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ArrayList<Animator.AnimatorListener> arrayList;
            AnimatorSet animatorSet = AnimatorSet.this;
            if (!animatorSet.mTerminated && animatorSet.mPlayingSet.size() == 0 && (arrayList = AnimatorSet.this.mListeners) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    AnimatorSet.this.mListeners.get(i3).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animator.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            boolean z16 = true;
            ((Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (!AnimatorSet.this.mTerminated) {
                ArrayList arrayList = this.mAnimatorSet.mSortedNodes;
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (!((Node) arrayList.get(i3)).done) {
                        z16 = false;
                        break;
                    }
                    i3++;
                }
                if (z16) {
                    ArrayList<Animator.AnimatorListener> arrayList2 = AnimatorSet.this.mListeners;
                    if (arrayList2 != null) {
                        ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                        int size2 = arrayList3.size();
                        for (int i16 = 0; i16 < size2; i16++) {
                            ((Animator.AnimatorListener) arrayList3.get(i16)).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    this.mAnimatorSet.mStarted = false;
                }
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class DependencyListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i3) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i3;
        }

        private void startIfReady(Animator animator) {
            Dependency dependency;
            if (this.mAnimatorSet.mTerminated) {
                return;
            }
            int size = this.mNode.tmpDependencies.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    dependency = null;
                    break;
                }
                Dependency dependency2 = this.mNode.tmpDependencies.get(i3);
                if (dependency2.rule == this.mRule && dependency2.node.animation == animator) {
                    animator.removeListener(this);
                    dependency = dependency2;
                    break;
                }
                i3++;
            }
            this.mNode.tmpDependencies.remove(dependency);
            if (this.mNode.tmpDependencies.size() == 0) {
                this.mNode.animation.start();
                this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
