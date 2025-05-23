package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(r0, r1);
        ClassLoader classLoader;
        FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
        if (fragmentManager.getHost() != null) {
            classLoader = fragmentManager.getHost().getContext().getClassLoader();
        } else {
            classLoader = null;
        }
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    private static boolean isFragmentPostponed(FragmentTransaction.Op op5) {
        Fragment fragment = op5.mFragment;
        if (fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bumpBackStackNesting(int i3) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "Bump nesting in " + this + " by " + i3);
        }
        int size = this.mOps.size();
        for (int i16 = 0; i16 < size; i16++) {
            FragmentTransaction.Op op5 = this.mOps.get(i16);
            Fragment fragment = op5.mFragment;
            if (fragment != null) {
                fragment.mBackStackNesting += i3;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(TAG, "Bump nesting of " + op5.mFragment + " to " + op5.mFragment.mBackStackNesting);
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean z16) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                dump("  ", printWriter);
                printWriter.close();
            }
            this.mCommitted = true;
            if (this.mAddToBackStack) {
                this.mIndex = this.mManager.allocBackStackIndex();
            } else {
                this.mIndex = -1;
            }
            this.mManager.enqueueAction(this, z16);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.detach(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int i3, Fragment fragment, @Nullable String str, int i16) {
        super.doAddOp(i3, fragment, str, i16);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executeOps() {
        int size = this.mOps.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransaction.Op op5 = this.mOps.get(i3);
            Fragment fragment = op5.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (op5.mCmd) {
                case 1:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.addFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op5.mCmd);
                case 3:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.attachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, op5.mCurrentMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && op5.mCmd != 1 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed && !FragmentManager.USE_STATE_MANAGER) {
            FragmentManager fragmentManager = this.mManager;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executePopOps(boolean z16) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op5 = this.mOps.get(size);
            Fragment fragment = op5.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (op5.mCmd) {
                case 1:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op5.mCmd);
                case 3:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.detachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, op5.mOldMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && op5.mCmd != 3 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed && z16 && !FragmentManager.USE_STATE_MANAGER) {
            FragmentManager fragmentManager = this.mManager;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i3 = 0;
        while (i3 < this.mOps.size()) {
            FragmentTransaction.Op op5 = this.mOps.get(i3);
            int i16 = op5.mCmd;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3 && i16 != 6) {
                        if (i16 != 7) {
                            if (i16 == 8) {
                                this.mOps.add(i3, new FragmentTransaction.Op(9, fragment2));
                                i3++;
                                fragment2 = op5.mFragment;
                            }
                        }
                    } else {
                        arrayList.remove(op5.mFragment);
                        Fragment fragment3 = op5.mFragment;
                        if (fragment3 == fragment2) {
                            this.mOps.add(i3, new FragmentTransaction.Op(9, fragment3));
                            i3++;
                            fragment2 = null;
                        }
                    }
                } else {
                    Fragment fragment4 = op5.mFragment;
                    int i17 = fragment4.mContainerId;
                    boolean z16 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.mContainerId == i17) {
                            if (fragment5 == fragment4) {
                                z16 = true;
                            } else {
                                if (fragment5 == fragment2) {
                                    this.mOps.add(i3, new FragmentTransaction.Op(9, fragment5));
                                    i3++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op6 = new FragmentTransaction.Op(3, fragment5);
                                op6.mEnterAnim = op5.mEnterAnim;
                                op6.mPopEnterAnim = op5.mPopEnterAnim;
                                op6.mExitAnim = op5.mExitAnim;
                                op6.mPopExitAnim = op5.mPopExitAnim;
                                this.mOps.add(i3, op6);
                                arrayList.remove(fragment5);
                                i3++;
                            }
                        }
                    }
                    if (z16) {
                        this.mOps.remove(i3);
                        i3--;
                    } else {
                        op5.mCmd = 1;
                        arrayList.add(fragment4);
                    }
                }
                i3++;
            }
            arrayList.add(op5.mFragment);
            i3++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.hide(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean interactsWith(int i3) {
        int size = this.mOps.size();
        for (int i16 = 0; i16 < size; i16++) {
            Fragment fragment = this.mOps.get(i16).mFragment;
            int i17 = fragment != null ? fragment.mContainerId : 0;
            if (i17 != 0 && i17 == i3) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPostponed() {
        for (int i3 = 0; i3 < this.mOps.size(); i3++) {
            if (isFragmentPostponed(this.mOps.get(i3))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.remove(fragment);
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i3 = 0; i3 < this.mCommitRunnables.size(); i3++) {
                this.mCommitRunnables.get(i3).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager == this.mManager) {
            if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
            }
            if (state != Lifecycle.State.DESTROYED) {
                return super.setMaxLifecycle(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i3 = 0; i3 < this.mOps.size(); i3++) {
            FragmentTransaction.Op op5 = this.mOps.get(i3);
            if (isFragmentPostponed(op5)) {
                op5.mFragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment != null && (fragmentManager = fragment.mFragmentManager) != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.setPrimaryNavigationFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.show(fragment);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append("BackStackEntry{");
        sb5.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb5.append(" #");
            sb5.append(this.mIndex);
        }
        if (this.mName != null) {
            sb5.append(" ");
            sb5.append(this.mName);
        }
        sb5.append("}");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op5 = this.mOps.get(size);
            int i3 = op5.mCmd;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op5.mFragment;
                            break;
                        case 10:
                            op5.mCurrentMaxState = op5.mOldMaxState;
                            break;
                    }
                }
                arrayList.add(op5.mFragment);
            }
            arrayList.remove(op5.mFragment);
        }
        return fragment;
    }

    public void dump(String str, PrintWriter printWriter, boolean z16) {
        String str2;
        if (z16) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mOps.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.mOps.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransaction.Op op5 = this.mOps.get(i3);
            switch (op5.mCmd) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + op5.mCmd;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(MsgSummary.STR_COLON);
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op5.mFragment);
            if (z16) {
                if (op5.mEnterAnim != 0 || op5.mExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op5.mEnterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op5.mExitAnim));
                }
                if (op5.mPopEnterAnim != 0 || op5.mPopExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op5.mPopEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op5.mPopExitAnim));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i3, int i16) {
        if (i16 == i3) {
            return false;
        }
        int size = this.mOps.size();
        int i17 = -1;
        for (int i18 = 0; i18 < size; i18++) {
            Fragment fragment = this.mOps.get(i18).mFragment;
            int i19 = fragment != null ? fragment.mContainerId : 0;
            if (i19 != 0 && i19 != i17) {
                for (int i26 = i3; i26 < i16; i26++) {
                    BackStackRecord backStackRecord = arrayList.get(i26);
                    int size2 = backStackRecord.mOps.size();
                    for (int i27 = 0; i27 < size2; i27++) {
                        Fragment fragment2 = backStackRecord.mOps.get(i27).mFragment;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i19) {
                            return true;
                        }
                    }
                }
                i17 = i19;
            }
        }
        return false;
    }
}
