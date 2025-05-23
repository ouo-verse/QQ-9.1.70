package com.tencent.biz.qqcircle.immersive.part;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkThirdShareAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends u {

    /* renamed from: d, reason: collision with root package name */
    private QCircleCustomDialog f88315d;

    /* renamed from: e, reason: collision with root package name */
    private String f88316e;

    /* renamed from: f, reason: collision with root package name */
    private View f88317f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, String> f88318h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            s.this.E9(Boolean.TRUE);
            s.this.f88315d.dismiss();
        }
    }

    private boolean C9(Context context, HashMap<String, String> hashMap) {
        return ((IWinkThirdShareAPI) QRoute.api(IWinkThirdShareAPI.class)).backToShareApp(context, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void D9() {
        char c16;
        String str;
        Intent intent = getActivity().getIntent();
        Context context = getContext();
        if (intent != null && context != null) {
            HashMap<String, String> F9 = F9(intent);
            if (F9 == null) {
                QLog.i("QFSBackToGameDialogPart", 1, "[backToBusiness] no schemaData");
                return;
            }
            if (C9(context, F9)) {
                return;
            }
            String str2 = F9.get("taskid");
            if (TextUtils.isEmpty(str2)) {
                QLog.i("QFSBackToGameDialogPart", 1, "[backToBusiness] no taskId");
                return;
            }
            switch (str2.hashCode()) {
                case -959337043:
                    if (str2.equals(QCircleScheme.AttrQQPublish.BUSINESS_AIO)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -445539093:
                    if (str2.equals(QCircleScheme.AttrQQPublish.BUSINESS_ZPLAN)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 450287237:
                    if (str2.equals(QCircleScheme.AttrQQPublish.BUSINESS_MINI_GAME)) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1103000584:
                    if (str2.equals(QCircleScheme.AttrQQPublish.BUSINESS_QQ_MINI_GAME)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1185628212:
                    if (str2.equals(QCircleScheme.AttrQQPublish.BUSINESS_MINI_SPARK)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        str = null;
                    } else {
                        str = this.f88318h.get(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
                    }
                } else {
                    str = this.f88318h.get("mini_app_id");
                }
            } else {
                str = this.f88318h.get(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
            }
            QLog.i("QFSBackToGameDialogPart", 1, "[backToBusiness] miniId=" + str);
            if (!TextUtils.isEmpty(str)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, str, "", "", 1131, null);
                return;
            }
            return;
        }
        QLog.i("QFSBackToGameDialogPart", 1, "[backToBusiness] no context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(Boolean bool) {
        String str;
        if (!TextUtils.isEmpty(this.f88316e) && this.f88317f != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (bool.booleanValue()) {
                str = QCircleDaTongConstant.ElementParamValue.STAY;
            } else {
                str = QCircleDaTongConstant.ElementParamValue.GOBACK;
            }
            buildElementParams.put("xsj_actiontype", str);
            buildElementParams.put("xsj_operation_activity_id", this.f88316e);
            VideoReport.setElementId(this.f88317f, QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISHING_PANEL);
            VideoReport.reportEvent("dt_clck", this.f88317f, buildElementParams);
        }
    }

    private HashMap<String, String> F9(Intent intent) {
        try {
            return (HashMap) intent.getSerializableExtra("key_attrs");
        } catch (Exception e16) {
            QLog.w("QFSBackToGameDialogPart", 1, "[getSchemaDataFromIntent] ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(DialogInterface dialogInterface, int i3) {
        E9(Boolean.FALSE);
        this.f88315d.dismiss();
        D9();
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean H9(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        return true;
    }

    public void I9() {
        if (this.f88315d == null) {
            QCircleCustomDialog U = QCircleCustomDialog.U(getContext(), getContext().getString(R.string.f193864ac), getContext().getString(R.string.f193854ab), com.tencent.biz.qqcircle.utils.h.a(R.string.f228476tu), getContext().getString(R.string.f189273yy), new a(), new b());
            this.f88315d = U;
            U.g0(getContext().getResources().getString(R.string.f189273yy), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    s.this.G9(dialogInterface, i3);
                }
            });
            this.f88315d.show();
            this.f88315d.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.biz.qqcircle.immersive.part.r
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    boolean H9;
                    H9 = s.H9(dialogInterface, i3, keyEvent);
                    return H9;
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSBackToGameDialogPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88317f = view;
        if (getActivity() != null && getActivity().getIntent() != null) {
            HashMap<String, String> hashMap = (HashMap) getActivity().getIntent().getSerializableExtra("key_attrs");
            this.f88318h = hashMap;
            if (hashMap == null) {
                return;
            }
            String str = hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
            this.f88316e = this.f88318h.get("taskid");
            if (!TextUtils.isEmpty(str) && "1".equals(str)) {
                I9();
                this.f88318h.remove(QCircleScheme.AttrQQPublish.BUSINESS_TASK_NAME);
                this.f88318h.remove(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
