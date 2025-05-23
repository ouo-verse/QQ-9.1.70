package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumAlbumDetailAnswerCheckPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "uiStateData", "E9", "H9", "initViewModel", "", "getLogTag", "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnc/y;", "d", "Lnc/y;", "detailViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumAlbumDetailAnswerCheckPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nc.y detailViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9() {
        String str;
        String str2;
        String str3;
        String str4;
        QZAlbumxAlbumDetailInitBean mInitBean;
        QZAlbumxAlbumDetailInitBean mInitBean2;
        String albumId;
        QZAlbumxAlbumDetailInitBean mInitBean3;
        QZAlbumxAlbumDetailInitBean mInitBean4;
        QZAlbumxAlbumDetailInitBean mInitBean5;
        QZAlbumxAlbumDetailInitBean mInitBean6;
        nc.y yVar = this.detailViewModel;
        String str5 = "";
        if (yVar == null || (mInitBean6 = yVar.getMInitBean()) == null || (str = mInitBean6.getUin()) == null) {
            str = "";
        }
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = new QZAlbumxAnswerCheckPageInitBean(str);
        nc.y yVar2 = this.detailViewModel;
        if (yVar2 == null || (mInitBean5 = yVar2.getMInitBean()) == null || (str2 = mInitBean5.getAlbumId()) == null) {
            str2 = "";
        }
        qZAlbumxAnswerCheckPageInitBean.setAlbumId(str2);
        nc.y yVar3 = this.detailViewModel;
        if (yVar3 == null || (mInitBean4 = yVar3.getMInitBean()) == null || (str3 = mInitBean4.getUin()) == null) {
            str3 = "";
        }
        qZAlbumxAnswerCheckPageInitBean.setOwnerUin(str3);
        nc.y yVar4 = this.detailViewModel;
        if (yVar4 == null || (mInitBean3 = yVar4.getMInitBean()) == null || (str4 = mInitBean3.getUin()) == null) {
            str4 = "";
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(str4);
        nc.y yVar5 = this.detailViewModel;
        if (yVar5 != null && (mInitBean2 = yVar5.getMInitBean()) != null && (albumId = mInitBean2.getAlbumId()) != null) {
            str5 = albumId;
        }
        qZAlbumxAlbumDetailInitBean.setAlbumId(str5);
        nc.y yVar6 = this.detailViewModel;
        qZAlbumxAlbumDetailInitBean.setSortType((yVar6 == null || (mInitBean = yVar6.getMInitBean()) == null) ? null : mInitBean.getSortType());
        qZAlbumxAnswerCheckPageInitBean.setJumpExtData(qZAlbumxAlbumDetailInitBean);
        qZAlbumxAnswerCheckPageInitBean.setFromType(0);
        vb.b x16 = ho.i.x();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        x16.d(activity, 1099, qZAlbumxAnswerCheckPageInitBean);
    }

    private final void initData() {
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1;
        nc.y yVar = this.detailViewModel;
        if (yVar == null || (O1 = yVar.O1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit> function1 = new Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailAnswerCheckPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> it) {
                QZAlbumAlbumDetailAnswerCheckPart qZAlbumAlbumDetailAnswerCheckPart = QZAlbumAlbumDetailAnswerCheckPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumAlbumDetailAnswerCheckPart.E9(it);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumAlbumDetailAnswerCheckPart.F9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        ViewModel Ne = cVar != null ? cVar.Ne() : null;
        this.detailViewModel = Ne instanceof nc.y ? (nc.y) Ne : null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumAlbumDetailAnswerCheckPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        QZAlbumxAlbumDetailInitBean mInitBean;
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1099) {
            return;
        }
        if (resultCode == 0) {
            getActivity().finish();
            return;
        }
        if (resultCode != -1) {
            return;
        }
        boolean z16 = false;
        if (data != null && data.hasExtra("verify_question_result")) {
            z16 = true;
        }
        if (!z16) {
            QLog.e(getTAG(), 1, "answer check has not value");
            return;
        }
        Object obj = (data == null || (extras = data.getExtras()) == null) ? null : extras.get("verify_question_result");
        if (!Intrinsics.areEqual(obj, (Object) 1) && !Intrinsics.areEqual(obj, (Object) 2)) {
            getActivity().finish();
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        nc.y yVar = this.detailViewModel;
        if (yVar == null || (mInitBean = yVar.getMInitBean()) == null || (str = mInitBean.getAlbumId()) == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QZAlbumxUpdateAlbumEvent(str));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        G9(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        if (uiStateData == null) {
            return;
        }
        if (((int) uiStateData.getRetCode()) == 10097) {
            H9();
        }
    }

    private final void G9(View rootView) {
    }
}
