package com.qzone.reborn.albumx.qzonex.part.upload;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditAlbumEvent;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAEditAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PersonalAlbumModifyType;
import com.tencent.qqnt.kernel.nativeinterface.QzoneAlbumModifyDesc;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0018\u00103\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R#\u0010:\u001a\n 5*\u0004\u0018\u000104048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadAlbumAuthorityBarPart;", "Lcom/qzone/reborn/base/k;", "", "P9", "O9", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "L9", "Q9", "K9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "H9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "d", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "e", "Landroid/view/View;", "albumAuthorityBarView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvAlbumAuthorityText", tl.h.F, "I", "privacy", "i", "albumRights", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "albumWhiteList", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "albumQuestion", "D", "albumAnswer", "E", "selectedPrivTag", UserInfo.SEX_FEMALE, "rawSelectedJson", "Lqc/e;", "kotlin.jvm.PlatformType", "G", "Lkotlin/Lazy;", "G9", "()Lqc/e;", "vm", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadAlbumAuthorityBarPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private String albumQuestion;

    /* renamed from: D, reason: from kotlin metadata */
    private String albumAnswer;

    /* renamed from: E, reason: from kotlin metadata */
    private String selectedPrivTag;

    /* renamed from: F, reason: from kotlin metadata */
    private String rawSelectedJson;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxUploadAlbumInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View albumAuthorityBarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumAuthorityText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int privacy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int albumRights;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<String> albumWhiteList;

    public QZAlbumxUploadAlbumAuthorityBarPart(QZAlbumxUploadAlbumInitBean initBean) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.privacy = -1;
        this.albumRights = -1;
        this.albumWhiteList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qc.e>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumAuthorityBarPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.e invoke() {
                return (qc.e) QZAlbumxUploadAlbumAuthorityBarPart.this.getViewModel(qc.e.class);
            }
        });
        this.vm = lazy;
    }

    private final qc.e G9() {
        return (qc.e) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZAlbumxUploadAlbumAuthorityBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZAlbumxUploadAlbumAuthorityBarPart this$0, CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (commonAlbumInfo != null) {
            View view = null;
            if (!com.qzone.reborn.albumx.qzonex.utils.c.f53402a.f(commonAlbumInfo)) {
                View view2 = this$0.albumAuthorityBarView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumAuthorityBarView");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                return;
            }
            View view3 = this$0.albumAuthorityBarView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumAuthorityBarView");
            } else {
                view = view3;
            }
            view.setVisibility(0);
            this$0.O9();
        }
    }

    private final void L9(CommonAlbumAccessPermission permission) {
        if (G9().Q1().getValue() != null) {
            CommonAlbumInfo value = G9().Q1().getValue();
            Intrinsics.checkNotNull(value);
            if (TextUtils.isEmpty(value.getAlbumId())) {
                return;
            }
            CommonAlbumInfo value2 = G9().Q1().getValue();
            Intrinsics.checkNotNull(value2);
            final CommonAlbumInfo commonAlbumInfo = value2;
            final CommonAlbumAccessPermission commonAlbumAccessPermission = commonAlbumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String();
            commonAlbumInfo.p0(permission);
            G9().a2(commonAlbumInfo);
            QzoneAlbumModifyDesc qzoneAlbumModifyDesc = new QzoneAlbumModifyDesc();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEPRIV.ordinal()));
            qzoneAlbumModifyDesc.modifyTypes.addAll(arrayList);
            final long currentTimeMillis = System.currentTimeMillis();
            PAEditAlbumReq pAEditAlbumReq = new PAEditAlbumReq();
            pAEditAlbumReq.album = xh.a.b(commonAlbumInfo);
            pAEditAlbumReq.modifyDesc = qzoneAlbumModifyDesc;
            pAEditAlbumReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
            z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
            if (b16 != null) {
                b16.editAlbum(pAEditAlbumReq, new IPersonalAlbumServiceEditAlbumCallback() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditAlbumCallback
                    public final void onEditAlbum(PAEditAlbumRsp pAEditAlbumRsp) {
                        QZAlbumxUploadAlbumAuthorityBarPart.M9(QZAlbumxUploadAlbumAuthorityBarPart.this, currentTimeMillis, commonAlbumInfo, commonAlbumAccessPermission, pAEditAlbumRsp);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(final QZAlbumxUploadAlbumAuthorityBarPart this$0, long j3, final CommonAlbumInfo editAlbum, final CommonAlbumAccessPermission permissionTemp, final PAEditAlbumRsp pAEditAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(editAlbum, "$editAlbum");
        Intrinsics.checkNotNullParameter(permissionTemp, "$permissionTemp");
        QLog.i(this$0.getTAG(), 1, "sendEditAlbumRequest seq:" + pAEditAlbumRsp.seq + " | traceId:" + pAEditAlbumRsp.traceId + " | resultCode:" + pAEditAlbumRsp.result + " | errMsg:" + pAEditAlbumRsp.errMs);
        mc.c.f416541a.e(QZoneOptAlbumRequest.FIELD_CMD_EDIT, System.currentTimeMillis() - j3, pAEditAlbumRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.e
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxUploadAlbumAuthorityBarPart.N9(PAEditAlbumRsp.this, this$0, editAlbum, permissionTemp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(PAEditAlbumRsp pAEditAlbumRsp, QZAlbumxUploadAlbumAuthorityBarPart this$0, CommonAlbumInfo editAlbum, CommonAlbumAccessPermission permissionTemp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(editAlbum, "$editAlbum");
        Intrinsics.checkNotNullParameter(permissionTemp, "$permissionTemp");
        if (pAEditAlbumRsp.result == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxEditAlbumEvent(this$0.G9().R1().getUin(), null, editAlbum, null, 8, null));
        } else {
            editAlbum.p0(permissionTemp);
            this$0.G9().a2(editAlbum);
        }
    }

    private final void O9() {
        if (G9().Q1().getValue() != null) {
            CommonAlbumInfo value = G9().Q1().getValue();
            Intrinsics.checkNotNull(value);
            if (TextUtils.isEmpty(value.getAlbumId())) {
                return;
            }
            com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
            CommonAlbumInfo value2 = G9().Q1().getValue();
            Intrinsics.checkNotNull(value2);
            String d16 = cVar.d(value2.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType());
            if (TextUtils.isEmpty(d16)) {
                return;
            }
            CommonAlbumInfo value3 = G9().Q1().getValue();
            Intrinsics.checkNotNull(value3);
            TextView textView = null;
            if (value3.getIsShareAlbum()) {
                TextView textView2 = this.tvAlbumAuthorityText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAlbumAuthorityText");
                } else {
                    textView = textView2;
                }
                textView.setText(d16 + com.qzone.util.l.a(R.string.s__));
                return;
            }
            TextView textView3 = this.tvAlbumAuthorityText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAlbumAuthorityText");
            } else {
                textView = textView3;
            }
            textView.setText(d16);
        }
    }

    private final void P9() {
        if (G9().Q1().getValue() != null) {
            CommonAlbumInfo value = G9().Q1().getValue();
            Intrinsics.checkNotNull(value);
            if (!TextUtils.isEmpty(value.getAlbumId())) {
                String j3 = yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}"), "{type}", "editphoto");
                if (H9()) {
                    j3 = j3 + "&tip=shareAlbum";
                }
                String str = j3 + "&source=UploadPhoto";
                Bundle bundle = new Bundle();
                CommonAlbumInfo value2 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value2);
                int a16 = com.qzone.feed.utils.h.a(value2.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType());
                bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, a16);
                CommonAlbumInfo value3 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value3);
                if (!bl.b(value3.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().e()) && TextUtils.isEmpty(this.rawSelectedJson)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    CommonAlbumInfo value4 = G9().Q1().getValue();
                    Intrinsics.checkNotNull(value4);
                    for (CommonStUser commonStUser : value4.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().e()) {
                        arrayList.add(commonStUser.getUin());
                        arrayList2.add(s8.f.f().g(commonStUser.getUin()));
                    }
                    bundle.putStringArrayList("uin_list", arrayList);
                    bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
                }
                if (a16 == 9999) {
                    CommonAlbumInfo value5 = G9().Q1().getValue();
                    Intrinsics.checkNotNull(value5);
                    bundle.putString(UgcSettingUtil.KEY_QUESTION, value5.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getQuestion());
                    CommonAlbumInfo value6 = G9().Q1().getValue();
                    Intrinsics.checkNotNull(value6);
                    bundle.putString(UgcSettingUtil.KEY_ANSWER, value6.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getAnswer());
                }
                if (com.qzone.feed.utils.h.h(a16) && !TextUtils.isEmpty(this.rawSelectedJson)) {
                    bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.rawSelectedJson);
                }
                yo.d.k(getActivity(), str, 2005, bundle, null, null);
                String tag = getTAG();
                CommonAlbumInfo value7 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value7);
                String albumId = value7.getAlbumId();
                CommonAlbumInfo value8 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value8);
                int permissionType = value8.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType();
                CommonAlbumInfo value9 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value9);
                int size = value9.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().e().size();
                String str2 = this.rawSelectedJson;
                CommonAlbumInfo value10 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value10);
                String question = value10.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getQuestion();
                CommonAlbumInfo value11 = G9().Q1().getValue();
                Intrinsics.checkNotNull(value11);
                QLog.i(tag, 1, "startUGCSettingH5 albumId:" + albumId + " | permissionType:" + permissionType + " | ugcPrivFlag:" + a16 + " | whiteList.size:" + size + " | rawSelectedJson:" + str2 + " | question:" + question + " | answer:" + value11.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getAnswer() + " | rawSelectedJson:" + this.rawSelectedJson);
                return;
            }
        }
        QZLog.e("QZAlbumxUploadAlbumAuthorityBarPart", "[startUGCSettingH5] empty albumcachedata");
        ToastUtil.o(R.string.jk6, 4);
    }

    private final CommonAlbumAccessPermission Q9() {
        CommonAlbumAccessPermission commonAlbumAccessPermission = new CommonAlbumAccessPermission();
        commonAlbumAccessPermission.g(this.albumRights);
        String str = this.albumQuestion;
        if (str == null) {
            str = "";
        }
        commonAlbumAccessPermission.j(str);
        String str2 = this.albumAnswer;
        commonAlbumAccessPermission.f(str2 != null ? str2 : "");
        for (String str3 : this.albumWhiteList) {
            CommonStUser commonStUser = new CommonStUser();
            commonStUser.g(str3);
            commonAlbumAccessPermission.e().add(commonStUser);
        }
        return commonAlbumAccessPermission;
    }

    public final boolean H9() {
        int i3;
        CommonShareAlbumMeta shareAlbum;
        List<CommonClientAttr> e16;
        CommonAlbumInfo value = G9().Q1().getValue();
        if (value == null || (shareAlbum = value.getShareAlbum()) == null || (e16 = shareAlbum.e()) == null) {
            i3 = 0;
        } else {
            Iterator<T> it = e16.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(((CommonClientAttr) it.next()).getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) {
                    i3++;
                }
            }
        }
        return i3 > 1;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxUploadAlbumAuthorityBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ArrayList<String> stringArrayList;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || requestCode != 2005 || data == null || data.getExtras() == null) {
            return;
        }
        K9();
        Bundle extras = data.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
            int i3 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
            this.privacy = i3;
            this.albumRights = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.k(Integer.valueOf(i3));
        }
        if (extras.containsKey("uin_list") && (stringArrayList = extras.getStringArrayList("uin_list")) != null) {
            this.albumWhiteList.addAll(stringArrayList);
        }
        if (extras.containsKey(UgcSettingUtil.KEY_QUESTION) && extras.containsKey(UgcSettingUtil.KEY_ANSWER)) {
            this.albumQuestion = extras.getString(UgcSettingUtil.KEY_QUESTION);
            this.albumAnswer = extras.getString(UgcSettingUtil.KEY_ANSWER);
        }
        if (com.qzone.feed.utils.h.h(this.privacy)) {
            this.selectedPrivTag = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
        }
        this.rawSelectedJson = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
        String tag = getTAG();
        CommonAlbumInfo value = G9().Q1().getValue();
        Intrinsics.checkNotNull(value);
        String albumId = value.getAlbumId();
        int i16 = this.privacy;
        int i17 = this.albumRights;
        int size = this.albumWhiteList.size();
        String str = this.rawSelectedJson;
        QLog.i(tag, 1, "onActivityResult albumId:" + albumId + " | privacy:" + i16 + " | albumRights:" + i17 + " | albumWhiteList.size:" + size + " | rawSelectedJson:" + str + " | albumQuestion:" + this.albumQuestion + " | albumAnswer:" + this.albumAnswer + " | selectedPrivTag:" + this.selectedPrivTag + " | rawSelectedJson:" + str);
        L9(Q9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (this.initBean.getAlbumInfo() != null) {
            com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
            CommonAlbumInfo albumInfo = this.initBean.getAlbumInfo();
            Intrinsics.checkNotNull(albumInfo);
            if (!cVar.f(albumInfo)) {
                return;
            }
        }
        if (rootView != null) {
            View inflate = ((ViewStub) rootView.findViewById(R.id.f246809s)).inflate();
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxUploadAlbumAuthorityBarPart.I9(QZAlbumxUploadAlbumAuthorityBarPart.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(inflate, "findViewById<ViewStub>(c\u2026      }\n                }");
            this.albumAuthorityBarView = inflate;
            View findViewById = inflate.findViewById(R.id.fp9);
            Intrinsics.checkNotNullExpressionValue(findViewById, "albumAuthorityBarView.fi\u2026_post_select_album_right)");
            this.tvAlbumAuthorityText = (TextView) findViewById;
            View view = this.albumAuthorityBarView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumAuthorityBarView");
                view = null;
            }
            View findViewById2 = view.findViewById(R.id.f68373fv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "albumAuthorityBarView.fi\u2026q.R.id.qzone_eye_on_icon)");
            com.tencent.mobileqq.qzone.picload.c.a().j((ImageView) findViewById2, new c.C8489c().h("qui_eye_on").e(R.color.qui_common_icon_primary));
            View view3 = this.albumAuthorityBarView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumAuthorityBarView");
            } else {
                view2 = view3;
            }
            fo.c.n(view2, "em_qz_permission_set");
        }
        G9().Q1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxUploadAlbumAuthorityBarPart.J9(QZAlbumxUploadAlbumAuthorityBarPart.this, (CommonAlbumInfo) obj);
            }
        });
    }

    private final void K9() {
        this.privacy = -1;
        this.albumRights = -1;
        this.albumWhiteList.clear();
        this.albumQuestion = "";
        this.albumAnswer = "";
        this.rawSelectedJson = "";
    }
}
