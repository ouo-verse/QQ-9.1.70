package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(com.tencent.mobileqq.R.id.f100835tk);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i3, @NonNull Context context) {
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(com.tencent.mobileqq.R.id.f100865tn);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(com.tencent.mobileqq.R.id.f100865tn, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i3);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i3, context);
        sparseArray.put(i3, scene2);
        return scene2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCurrentScene(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        viewGroup.setTag(com.tencent.mobileqq.R.id.f100835tk, scene);
    }

    public void enter() {
        if (this.mLayoutId > 0 || this.mLayout != null) {
            getSceneRoot().removeAllViews();
            if (this.mLayoutId > 0) {
                LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            } else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }
        Runnable runnable = this.mEnterAction;
        if (runnable != null) {
            runnable.run();
        }
        setCurrentScene(this.mSceneRoot, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) == this && (runnable = this.mExitAction) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId > 0) {
            return true;
        }
        return false;
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.mExitAction = runnable;
    }

    Scene(ViewGroup viewGroup, int i3, Context context) {
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i3;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }
}
