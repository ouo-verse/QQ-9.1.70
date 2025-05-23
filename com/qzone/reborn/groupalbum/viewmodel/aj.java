package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IReddotReaderServiceGetRedPointsCallback;
import com.tencent.qqnt.kernel.nativeinterface.SceneType;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroid/content/Intent;", "intent", "", "S1", "", "index", "Z1", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneType;", "scene", "Lcom/tencent/qqnt/kernel/nativeinterface/IReddotReaderServiceGetRedPointsCallback;", "callback", "T1", "i", "I", "Q1", "()I", "setMTabIndex", "(I)V", "mTabIndex", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "setTabIndexLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "tabIndexLiveData", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "P1", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "X1", "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;)V", "mMainInitBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aj extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    public GroupAlbumMainPageInitBean mMainInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTabIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> tabIndexLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(final aj this$0, final IReddotReaderServiceGetRedPointsCallback callback, final int i3, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.ai
            @Override // java.lang.Runnable
            public final void run() {
                aj.W1(aj.this, i3, i16, callback, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(aj this$0, int i3, int i16, IReddotReaderServiceGetRedPointsCallback callback, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.e(this$0.getTAG(), 1, "requestRedPoint seq: " + i3 + " | resultCode: " + i16);
        callback.onGetRedPoints(i3, i16, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(aj this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabIndexLiveData.postValue(Integer.valueOf(this$0.mTabIndex));
    }

    public final GroupAlbumMainPageInitBean P1() {
        GroupAlbumMainPageInitBean groupAlbumMainPageInitBean = this.mMainInitBean;
        if (groupAlbumMainPageInitBean != null) {
            return groupAlbumMainPageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMainInitBean");
        return null;
    }

    /* renamed from: Q1, reason: from getter */
    public final int getMTabIndex() {
        return this.mTabIndex;
    }

    public final MutableLiveData<Integer> R1() {
        return this.tabIndexLiveData;
    }

    public final void T1(SceneType scene, final IReddotReaderServiceGetRedPointsCallback callback) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        IReddotReaderServiceGetRedPointsCallback iReddotReaderServiceGetRedPointsCallback = new IReddotReaderServiceGetRedPointsCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.ag
            @Override // com.tencent.qqnt.kernel.nativeinterface.IReddotReaderServiceGetRedPointsCallback
            public final void onGetRedPoints(int i3, int i16, String str, ArrayList arrayList) {
                aj.U1(aj.this, callback, i3, i16, str, arrayList);
            }
        };
        if (b16 != null) {
            b16.J(scene, P1().getGroupId(), iReddotReaderServiceGetRedPointsCallback);
        }
    }

    public final void X1(GroupAlbumMainPageInitBean groupAlbumMainPageInitBean) {
        Intrinsics.checkNotNullParameter(groupAlbumMainPageInitBean, "<set-?>");
        this.mMainInitBean = groupAlbumMainPageInitBean;
    }

    public final void Z1(int index) {
        this.mTabIndex = index;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.ah
            @Override // java.lang.Runnable
            public final void run() {
                aj.a2(aj.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumMainPageTabViewModel";
    }

    public final void S1(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean");
        X1((GroupAlbumMainPageInitBean) serializable);
        this.mTabIndex = P1().getTabId();
    }
}
