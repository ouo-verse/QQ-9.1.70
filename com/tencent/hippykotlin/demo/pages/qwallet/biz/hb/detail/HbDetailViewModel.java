package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.base.page_compose.QWalletBaseViewModel;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailRsp;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailStartupData;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbReceiver;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.h;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailViewModel extends QWalletBaseViewModel {
    public final MutableState<Boolean> hasGrabbed;
    public MutableState<Boolean> hasMoreData;
    public final MutableState<HbDetailRsp> hbDetailRsp;
    public MutableState<Boolean> isLoading;
    public final d listViewState = new d(0, 0.0f, 3, null);
    public final SnapshotStateList<HbReceiver> receiverList;
    public final MutableState<HbDetailStartupData> startupData;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HbDetailViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<HbDetailStartupData> mutableStateOf$default3;
        MutableState<HbDetailRsp> mutableStateOf$default4;
        MutableState<Boolean> mutableStateOf$default5;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasMoreData = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isLoading = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.startupData = mutableStateOf$default3;
        this.receiverList = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.hbDetailRsp = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasGrabbed = mutableStateOf$default5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qwallet.base.page_compose.QWalletBaseViewModel, com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(c cVar, Lifecycle.Event event) {
        QWLog qWLog = QWLog.INSTANCE;
        QWLog.INSTANCE.i("HbDetailViewModel", "onStateChanged: " + event, false);
        if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 1) {
            MutableState<HbDetailStartupData> mutableState = this.startupData;
            e m3 = h.a().getPagerData().n().m("HbDetailStartupData");
            mutableState.setValue(new HbDetailStartupData(m3 != null ? m3.p("listId") : null, m3 != null ? m3.p("authKey") : null, m3 != null ? m3.p(NotifyMsgApiImpl.KEY_GROUP_TYPE) : null, m3 != null ? m3.p("groupId") : null));
            QWLog.INSTANCE.i("HbDetailViewModel", "initData: " + this.startupData, false);
            requestData(0, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, java.lang.String] */
    public final void requestData(int i3, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        HbDetailStartupData value = this.startupData.getValue();
        if (value == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = value.listId;
        if (str != null) {
        }
        String str2 = value.authKey;
        if (str2 != null) {
        }
        String str3 = value.groupType;
        if (str3 != null) {
        }
        String str4 = value.groupId;
        if (str4 != null) {
        }
        hashMap.put("offset", String.valueOf(i3));
        hashMap.put("uin", PageDataExtKt.getUin(h.a().getPagerData()));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((CharSequence) objectRef.element).length() > 0) {
                objectRef.element = LoadFailParams$$ExternalSyntheticOutline0.m(new StringBuilder(), (String) objectRef.element, Typography.amp);
            }
            objectRef.element = ((String) objectRef.element) + ((String) entry.getKey()) + '=' + ((String) entry.getValue());
        }
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new HbDetailViewModel$requestData$5(this, objectRef, i3, function2, null), 3, null);
    }
}
