package com.tencent.mobileqq.ark.share.impl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.template.IPositionMsgApi;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.aio.msg.template.a;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.ark.share.ShareArkView;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ak;
import com.tencent.mobileqq.utils.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import d91.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/ark/share/impl/ShareArkViewApiImpl;", "Lcom/tencent/mobileqq/ark/share/IShareArkViewApi;", "Landroid/view/View;", "view", "", "appName", QQCustomArkDialogUtil.APP_VIEW, "", "addBorderToShareView", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "Landroid/os/Bundle;", "bundle", "setStructMsgTemplateByBundle", "Landroid/content/Context;", "context", "createShareArkView", "getTemplateInfoByBundle", "arkAppName", "getMetaData", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ShareArkViewApiImpl implements IShareArkViewApi {
    private static final String TAG = "TemMsg.ShareArkViewApi";

    private final void addBorderToShareView(View view, String appName, String appView) {
        b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
        boolean z16 = false;
        if (((arkAIKeyWordConfig != null ? arkAIKeyWordConfig.c().d(appName) : false) && !ArkMsgUtils.isMultiMsg(appName, appView)) && ArkMsgUtils.shouldShowBorderInSetSize(appName, appView)) {
            z16 = true;
        }
        if (z16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(1, SupportMenu.CATEGORY_MASK);
            view.setPadding(1, 1, 1, 1);
            view.setBackground(gradientDrawable);
        }
    }

    private final void setStructMsgTemplateByBundle(d templateMsgInfo, Bundle bundle) {
        JSONObject jSONObject;
        templateMsgInfo.g("com.tencent.structmsg");
        templateMsgInfo.l(i.b(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE)));
        String metaData = getMetaData(bundle, templateMsgInfo.a());
        try {
            jSONObject = new JSONObject(metaData);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "setStructMsgTemplateByBundle exception:" + e16 + ", " + metaData);
            jSONObject = null;
        }
        templateMsgInfo.j(jSONObject);
    }

    @Override // com.tencent.mobileqq.ark.share.IShareArkViewApi
    public View createShareArkView(Context context, Bundle bundle) {
        String string;
        a createTemplateMsgView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (ak.n(bundle) && (createTemplateMsgView = ((ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class)).createTemplateMsgView(context)) != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ShareArkViewApiImpl$createShareArkView$1$1(this, bundle, createTemplateMsgView, null), 2, null);
            return createTemplateMsgView.d();
        }
        String string2 = bundle.getString("appName");
        if (((IPositionMsgApi) QRoute.api(IPositionMsgApi.class)).isPositionMsg(string2) && (string = bundle.getString(QQCustomArkDialogUtil.META_DATA)) != null) {
            View createPositionMsgView = ((IPositionMsgApi) QRoute.api(IPositionMsgApi.class)).createPositionMsgView(context);
            addBorderToShareView(createPositionMsgView, string2, null);
            ((IPositionMsgApi) QRoute.api(IPositionMsgApi.class)).bindPositionMsgView(context, createPositionMsgView, string);
            return createPositionMsgView;
        }
        ShareArkView shareArkView = new ShareArkView(context, null, 0, 6, null);
        shareArkView.n(context, bundle);
        return shareArkView;
    }

    @Override // com.tencent.mobileqq.ark.share.IShareArkViewApi
    public d getTemplateInfoByBundle(Bundle bundle) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QQCustomArkDialog.b bVar = new QQCustomArkDialog.b(bundle);
        try {
            jSONObject = new JSONObject(bVar.f307112e);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getTemplateInfoByBundle failed for exception:" + e16);
            jSONObject = null;
        }
        d dVar = new d();
        if (!TextUtils.isEmpty(bVar.f307108a) && !TextUtils.isEmpty(bVar.f307109b) && jSONObject != null) {
            dVar.g(bVar.f307108a);
            dVar.l(bVar.f307109b);
            dVar.k(bVar.f307116i);
            dVar.j(jSONObject);
            dVar.h(bVar.f307110c);
        } else {
            setStructMsgTemplateByBundle(dVar, bundle);
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getMetaData(Bundle bundle, String arkAppName) {
        int i3;
        JSONObject jSONObject;
        String jSONObject2;
        String replace$default;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str4;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        int i16 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        long j3 = bundle.getLong("req_share_id");
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
        String string4 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        String string5 = bundle.getString("image_url");
        String string6 = bundle.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        String string7 = bundle.getString("app_name");
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6.put("title", string);
            if (i16 == 2) {
                string6 = QQCustomArkDialog.H0(string6);
                jSONObject6.put("musicUrl", string6);
                str = "music";
            } else if (i16 == 4) {
                str = "video";
            } else {
                str = "news";
            }
            if (TextUtils.isEmpty(string2)) {
                str2 = "video";
                str3 = string6;
                jSONObject3 = jSONObject6;
                jSONObject4 = jSONObject5;
            } else {
                Intrinsics.checkNotNull(string2);
                String qqStr = HardCodeUtil.qqStr(R.string.qnz);
                try {
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_qqcustom_82b85728)");
                    str2 = "video";
                    try {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) string2, (CharSequence) qqStr, false, 2, (Object) null);
                        if (contains$default) {
                            String qqStr2 = HardCodeUtil.qqStr(R.string.f172427qo3);
                            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qqstr_qqcustom_c49aa6c3)");
                            str3 = string6;
                            jSONObject3 = jSONObject6;
                            jSONObject4 = jSONObject5;
                            try {
                                string2 = StringsKt__StringsJVMKt.replace$default(string2, qqStr2, "", false, 4, (Object) null);
                            } catch (Exception e16) {
                                e = e16;
                                jSONObject = jSONObject4;
                                i3 = 2;
                                if (QLog.isColorLevel()) {
                                    QLog.e("QQCustomArkDialog", i3, e.toString());
                                }
                                jSONObject2 = jSONObject.toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
                                if (!TextUtils.isEmpty(jSONObject2)) {
                                }
                            }
                        } else {
                            str3 = string6;
                            jSONObject4 = jSONObject5;
                            jSONObject3 = jSONObject6;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 2;
                        jSONObject = jSONObject5;
                        if (QLog.isColorLevel()) {
                        }
                        jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
                        if (!TextUtils.isEmpty(jSONObject2)) {
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    jSONObject = jSONObject5;
                    i3 = 2;
                    if (QLog.isColorLevel()) {
                    }
                    jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
                    if (!TextUtils.isEmpty(jSONObject2)) {
                    }
                }
            }
            jSONObject3.put("desc", string2);
            if (TextUtils.isEmpty(string4)) {
                if (TextUtils.isEmpty(string5)) {
                    string4 = "";
                } else {
                    String E0 = QQCustomArkDialog.E0(string5);
                    string4 = ArkEnvironmentManager.getInstance().getAppResPath(arkAppName) + File.separator + E0;
                    FileUtils.copyFile(string5, string4);
                }
            }
            jSONObject3.put("preview", string4);
            jSONObject3.put("tag", string7);
            i3 = 2;
            if (i16 != 2) {
                str4 = i16 != 4 ? str : str2;
            } else {
                try {
                    jSONObject3.put("musicUrl", str3);
                    str4 = "music";
                } catch (Exception e19) {
                    e = e19;
                    jSONObject = jSONObject4;
                    if (QLog.isColorLevel()) {
                    }
                    jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
                    if (!TextUtils.isEmpty(jSONObject2)) {
                    }
                }
            }
            jSONObject3.put(WadlProxyConsts.KEY_JUMP_URL, QQCustomArkDialog.H0(string3));
            jSONObject3.put("appid", j3);
            jSONObject3.put("app_type", 1);
            jSONObject = jSONObject4;
        } catch (Exception e26) {
            e = e26;
            i3 = 2;
        }
        try {
            jSONObject.put(str4, jSONObject3);
        } catch (Exception e27) {
            e = e27;
            if (QLog.isColorLevel()) {
            }
            jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
            if (!TextUtils.isEmpty(jSONObject2)) {
            }
        }
        jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
        if (!TextUtils.isEmpty(jSONObject2)) {
            return jSONObject2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(jSONObject2, "\\/", "/", false, 4, (Object) null);
        return replace$default;
    }
}
