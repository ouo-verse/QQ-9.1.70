package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditPermissionsPart;", "Lcom/qzone/reborn/base/k;", "", "O9", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "K9", "Landroid/content/Intent;", "data", "N9", "", "ugcPrivType", "R9", "Landroid/view/View;", "view", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvPermission", "e", "Landroid/view/View;", "tvPermissionContainer", "Lnc/au;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "J9", "()Lnc/au;", "vm", "", tl.h.F, "Ljava/lang/String;", "mRawSelectedJson", "i", "mSelecetdPrivTag", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditPermissionsPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvPermission;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View tvPermissionContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mRawSelectedJson;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mSelecetdPrivTag;

    public QZAlbumxEditPermissionsPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditPermissionsPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditPermissionsPart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
        this.mRawSelectedJson = "";
        this.mSelecetdPrivTag = "";
    }

    private final void I9(View view) {
        fo.c.o(view, "em_qz_permission_set", new fo.b());
    }

    private final au J9() {
        return (au) this.vm.getValue();
    }

    private final boolean K9(CommonAlbumInfo albumInfo) {
        return albumInfo.getShareAlbum().e().size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZAlbumxEditPermissionsPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O9() {
        CommonAlbumEditInitBean value = J9().M1().getValue();
        if ((value != null ? value.getAlbumInfo() : null) == null) {
            return;
        }
        CommonAlbumEditInitBean value2 = J9().M1().getValue();
        Intrinsics.checkNotNull(value2);
        final CommonAlbumInfo albumInfo = value2.getAlbumInfo();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.u
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxEditPermissionsPart.P9(CommonAlbumInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(final CommonAlbumInfo albumInfo, final QZAlbumxEditPermissionsPart this$0) {
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Bundle bundle = new Bundle();
        int h16 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.h(Integer.valueOf(albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()));
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, h16);
        List<CommonStUser> e16 = albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().e();
        if (!(e16 == null || e16.isEmpty()) && TextUtils.isEmpty(this$0.mRawSelectedJson)) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (CommonStUser commonStUser : albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().e()) {
                arrayList.add(commonStUser.getUin());
                arrayList2.add(s8.f.f().g(commonStUser.getUin()));
            }
            bundle.putStringArrayList("uin_list", arrayList);
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
        }
        if (h16 == 9999) {
            bundle.putString(UgcSettingUtil.KEY_QUESTION, albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getQuestion());
            bundle.putString(UgcSettingUtil.KEY_ANSWER, albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getAnswer());
        }
        if (com.qzone.feed.utils.h.h(h16) && !TextUtils.isEmpty(this$0.mRawSelectedJson)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this$0.mRawSelectedJson);
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.v
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxEditPermissionsPart.Q9(QZAlbumxEditPermissionsPart.this, albumInfo, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZAlbumxEditPermissionsPart this$0, CommonAlbumInfo albumInfo, Bundle extras) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        String j3 = yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}"), "{type}", "editphoto");
        if (this$0.K9(albumInfo)) {
            j3 = j3 + "&tip=shareAlbumV2";
        }
        yo.d.k(this$0.getActivity(), j3, 5, extras, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(int ugcPrivType) {
        String d16;
        if (com.qzone.feed.utils.h.h(ugcPrivType) && !TextUtils.isEmpty(this.mSelecetdPrivTag)) {
            d16 = this.mSelecetdPrivTag;
        } else {
            d16 = com.qzone.feed.utils.h.d(ugcPrivType);
            Intrinsics.checkNotNullExpressionValue(d16, "getNewPrivNameFromShuoShuo(ugcPrivType)");
        }
        if (this.tvPermission == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPermission");
        }
        TextView textView = this.tvPermission;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPermission");
            textView = null;
        }
        textView.setText(d16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 5) {
            N9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.m7f);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxEditPermissionsPart.L9(QZAlbumxEditPermissionsPart.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026          }\n            }");
            this.tvPermissionContainer = findViewById;
            View findViewById2 = findViewById.findViewById(R.id.njc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tvPermissionContainer.findViewById(R.id.tv_name)");
            this.tvPermission = (TextView) findViewById2;
            View view = this.tvPermissionContainer;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPermissionContainer");
                view = null;
            }
            view.setVisibility(8);
            View view3 = this.tvPermissionContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPermissionContainer");
            } else {
                view2 = view3;
            }
            I9(view2);
        }
        LiveData<CommonAlbumEditInitBean> M1 = J9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditPermissionsPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                invoke2(commonAlbumEditInitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                View view4;
                if (commonAlbumEditInitBean == null) {
                    return;
                }
                com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
                if (cVar.f(commonAlbumEditInitBean.getAlbumInfo())) {
                    view4 = QZAlbumxEditPermissionsPart.this.tvPermissionContainer;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvPermissionContainer");
                        view4 = null;
                    }
                    view4.setVisibility(0);
                    QZAlbumxEditPermissionsPart.this.R9(cVar.h(Integer.valueOf(commonAlbumEditInitBean.getAlbumInfo().getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType())));
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditPermissionsPart.M9(Function1.this, obj);
            }
        });
    }

    private final void N9(Intent data) {
        int i3;
        CommonAlbumInfo albumInfo;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        ArrayList<String> stringArrayList;
        if (data != null) {
            Bundle extras = data.getExtras();
            if (extras == null) {
                return;
            }
            CommonAlbumAccessPermission commonAlbumAccessPermission2 = new CommonAlbumAccessPermission();
            if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                i3 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                commonAlbumAccessPermission2.g(com.qzone.reborn.albumx.qzonex.utils.c.f53402a.k(Integer.valueOf(i3)));
            } else {
                i3 = -1;
            }
            if (extras.containsKey("uin_list") && (stringArrayList = extras.getStringArrayList("uin_list")) != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String uin = it.next();
                    List<CommonStUser> e16 = commonAlbumAccessPermission2.e();
                    CommonStUser commonStUser = new CommonStUser();
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    commonStUser.g(uin);
                    e16.add(commonStUser);
                }
            }
            if (extras.containsKey(UgcSettingUtil.KEY_QUESTION) && extras.containsKey(UgcSettingUtil.KEY_ANSWER)) {
                String string = extras.getString(UgcSettingUtil.KEY_QUESTION, "");
                Intrinsics.checkNotNullExpressionValue(string, "extras.getString(UgcSettingUtil.KEY_QUESTION, \"\")");
                commonAlbumAccessPermission2.j(string);
                String string2 = extras.getString(UgcSettingUtil.KEY_ANSWER, "");
                Intrinsics.checkNotNullExpressionValue(string2, "extras.getString(UgcSettingUtil.KEY_ANSWER, \"\")");
                commonAlbumAccessPermission2.f(string2);
            }
            if (i3 == -1) {
                com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
                CommonAlbumEditInitBean value = J9().M1().getValue();
                i3 = cVar.h((value == null || (albumInfo = value.getAlbumInfo()) == null || (commonAlbumAccessPermission = albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) == null) ? null : Integer.valueOf(commonAlbumAccessPermission.getPermissionType()));
            }
            if (com.qzone.feed.utils.h.h(i3)) {
                String string3 = extras.getString(UgcSettingUtil.KEY_TAG_INFO, "");
                Intrinsics.checkNotNullExpressionValue(string3, "extras.getString(UgcSettingUtil.KEY_TAG_INFO, \"\")");
                this.mSelecetdPrivTag = string3;
            }
            String string4 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, "");
            Intrinsics.checkNotNullExpressionValue(string4, "extras.getString(UgcSett\u2026UGC_SETTING_RAW_JSON, \"\")");
            this.mRawSelectedJson = string4;
            R9(i3);
            J9().B2(commonAlbumAccessPermission2);
            return;
        }
        QZLog.w("QZAlbumxEditPermissionsPart", "REQUEST_CODE_UGC_PERMISSION DATA IS NULL");
    }
}
