package com.tencent.mobileqq.util.conversationtitlebutton;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/f;", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "", "", "list", "value", "", "a", "Lmqq/app/AppRuntime;", "appInterface", "getRedPointPaths", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface {
    private final void a(List<String> list, String value) {
        if (list.contains(value)) {
            return;
        }
        list.add(value);
    }

    @Override // com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
    public List<String> getRedPointPaths(AppRuntime appInterface) {
        ArrayList<ConversationTitleBtnConfig> a16;
        ArrayList arrayList = new ArrayList();
        if (!(appInterface instanceof QQAppInterface)) {
            return arrayList;
        }
        b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("qq_conversation_second_button_config");
        if (bVar != null && !bVar.a().isEmpty()) {
            for (ConversationTitleBtnConfig conversationTitleBtnConfig : bVar.a()) {
                if (!conversationTitleBtnConfig.i()) {
                    QLog.i("TitleButtonDynamicRedPoint", 1, "config is invalid, config=" + conversationTitleBtnConfig);
                } else {
                    if (conversationTitleBtnConfig.getRedDotAppId() > 0) {
                        a(arrayList, String.valueOf(conversationTitleBtnConfig.getRedDotAppId()));
                    }
                    if (conversationTitleBtnConfig.getTipsAppId() > 0) {
                        a(arrayList, String.valueOf(conversationTitleBtnConfig.getTipsAppId()));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("TitleButtonDynamicRedPoint", 1, "red point paths: " + arrayList);
            }
            return arrayList;
        }
        QLog.i("TitleButtonDynamicRedPoint", 1, "invalid config, config=" + ((bVar == null || (a16 = bVar.a()) == null) ? null : Integer.valueOf(a16.size())));
        return arrayList;
    }
}
