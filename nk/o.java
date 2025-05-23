package nk;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.intimate.bean.init.QZIntimateSettingPageBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lnk/o;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Intent;", "intent", "", "O1", "", "getLogTag", "Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "i", "Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "M1", "()Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "setSettingPageBean", "(Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;)V", "settingPageBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "spaceId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class o extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZIntimateSettingPageBean settingPageBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: M1, reason: from getter */
    public final QZIntimateSettingPageBean getSettingPageBean() {
        return this.settingPageBean;
    }

    /* renamed from: N1, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZIntimateSettingPageViewModel";
    }

    public final void O1(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof QZIntimateSettingPageBean) {
            QZIntimateSettingPageBean qZIntimateSettingPageBean = (QZIntimateSettingPageBean) serializable;
            this.settingPageBean = qZIntimateSettingPageBean;
            this.spaceId = qZIntimateSettingPageBean.getSpaceId();
        }
    }
}
