package com.tencent.aelight.camera.aioeditor.takevideo.eliminate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationScene;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/eliminate/EliminateLayoutFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/editor/aielimination/IEditPicEliminateOpCallback;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "Landroid/graphics/Bitmap;", "getOriginBitmap", "", "isDo", "resultBitmap", "onEliminateResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/util/WeakReference;", "callback", "Lmqq/util/WeakReference;", "<init>", "()V", "Companion", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class EliminateLayoutFragment extends ImmersivePartFragment implements IEditPicEliminateOpCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "EliminateLayoutFragment";
    private WeakReference<IEditPicEliminateOpCallback> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/eliminate/EliminateLayoutFragment$a;", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/IEditPicEliminateOpCallback;", "provider", "Lcom/tencent/aelight/camera/aioeditor/takevideo/eliminate/EliminateLayoutFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.eliminate.EliminateLayoutFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EliminateLayoutFragment a(IEditPicEliminateOpCallback provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            EliminateLayoutFragment eliminateLayoutFragment = new EliminateLayoutFragment();
            eliminateLayoutFragment.callback = new WeakReference(provider);
            return eliminateLayoutFragment;
        }

        Companion() {
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return f.b(this, i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dlh;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback
    public Bitmap getOriginBitmap() {
        IEditPicEliminateOpCallback iEditPicEliminateOpCallback;
        IEventReceiver iEventReceiver;
        EditVideoPartManager manager;
        List<u> Z;
        Object obj;
        if (this.callback == null) {
            Activity hostActivity = getHostActivity();
            EditPicActivity editPicActivity = hostActivity instanceof EditPicActivity ? (EditPicActivity) hostActivity : null;
            if (editPicActivity == null || (manager = editPicActivity.getManager()) == null || (Z = manager.Z()) == null) {
                iEventReceiver = null;
            } else {
                Iterator<T> it = Z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((u) obj) instanceof EditPicAIEliminatePart) {
                        break;
                    }
                }
                iEventReceiver = (u) obj;
            }
            this.callback = new WeakReference<>(iEventReceiver instanceof IEditPicEliminateOpCallback ? (IEditPicEliminateOpCallback) iEventReceiver : null);
        }
        WeakReference<IEditPicEliminateOpCallback> weakReference = this.callback;
        if (weakReference == null || (iEditPicEliminateOpCallback = weakReference.get()) == null) {
            return null;
        }
        return iEditPicEliminateOpCallback.getOriginBitmap();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        f.c(this, activity);
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return f.d(this);
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return f.e(this);
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return f.f(this);
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return f.g(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        FragmentTransaction beginTransaction;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if ((fragmentManager != null ? fragmentManager.findFragmentByTag("ELIMINATION_TAG") : null) != null) {
                FragmentManager fragmentManager2 = getFragmentManager();
                Fragment findFragmentByTag = fragmentManager2 != null ? fragmentManager2.findFragmentByTag("ELIMINATION_TAG") : null;
                WinkAIEliminationFragment winkAIEliminationFragment = findFragmentByTag instanceof WinkAIEliminationFragment ? (WinkAIEliminationFragment) findFragmentByTag : null;
                if (winkAIEliminationFragment != null) {
                    winkAIEliminationFragment.Mi(new WeakReference<>(this));
                    return;
                }
                return;
            }
        }
        b.a(TAG, "onCreate fragment");
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        intent.putExtra(WinkDTParamBuilder.APP_KEY_NAME, "0AND0MWZXR4U3RVU");
        WinkDTParamBuilder.setDtParams(intent);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        companion.o(companion.a(intent));
        WinkAIEliminationFragment a16 = WinkAIEliminationFragment.INSTANCE.a(null, 0, AIEliminationScene.AIO_EDITOR, intent.getExtras());
        a16.Mi(new WeakReference<>(this));
        FragmentManager fragmentManager3 = getFragmentManager();
        if (fragmentManager3 == null || (beginTransaction = fragmentManager3.beginTransaction()) == null || (replace = beginTransaction.replace(R.id.rsu, a16, "ELIMINATION_TAG")) == null || (addToBackStack = replace.addToBackStack("ELIMINATION_TAG")) == null) {
            return;
        }
        addToBackStack.commitAllowingStateLoss();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        b.a(TAG, "onDestroy...");
        super.onDestroy();
        this.callback = null;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback
    public void onEliminateResult(boolean isDo, Bitmap resultBitmap) {
        IEditPicEliminateOpCallback iEditPicEliminateOpCallback;
        Object obj;
        EditVideoPartManager manager;
        List<u> Z;
        Object obj2;
        if (this.callback == null) {
            Activity hostActivity = getHostActivity();
            EditPicActivity editPicActivity = hostActivity instanceof EditPicActivity ? (EditPicActivity) hostActivity : null;
            if (editPicActivity == null || (manager = editPicActivity.getManager()) == null || (Z = manager.Z()) == null) {
                obj = null;
            } else {
                Iterator<T> it = Z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it.next();
                        if (((u) obj2) instanceof EditPicAIEliminatePart) {
                            break;
                        }
                    }
                }
                obj = (u) obj2;
            }
            this.callback = new WeakReference<>(obj instanceof IEditPicEliminateOpCallback ? (IEditPicEliminateOpCallback) obj : null);
        }
        WeakReference<IEditPicEliminateOpCallback> weakReference = this.callback;
        if (weakReference == null || (iEditPicEliminateOpCallback = weakReference.get()) == null) {
            return;
        }
        iEditPicEliminateOpCallback.onEliminateResult(isDo, resultBitmap);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        f.k(this);
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        f.l(this);
    }

    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return f.o(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
