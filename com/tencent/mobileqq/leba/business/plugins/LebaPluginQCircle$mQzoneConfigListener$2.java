package com.tencent.mobileqq.leba.business.plugins;

import com.tencent.mobileqq.leba.business.plugins.LebaPluginQCircle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcommon/config/service/QzoneConfig$QzoneConfigChangeListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
final class LebaPluginQCircle$mQzoneConfigListener$2 extends Lambda implements Function0<QzoneConfig.QzoneConfigChangeListener> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LebaPluginQCircle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LebaPluginQCircle$mQzoneConfigListener$2(LebaPluginQCircle lebaPluginQCircle) {
        super(0);
        this.this$0 = lebaPluginQCircle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginQCircle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LebaPluginQCircle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("LebaPluginQCircle", 1, "onQzoneConfigChanged ");
        com.tencent.mobileqq.leba.util.a.b(new LebaPluginQCircle.MainUpdateRedFlagTask(this$0));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QzoneConfig.QzoneConfigChangeListener invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QzoneConfig.QzoneConfigChangeListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final LebaPluginQCircle lebaPluginQCircle = this.this$0;
        return new QzoneConfig.QzoneConfigChangeListener() { // from class: com.tencent.mobileqq.leba.business.plugins.x
            @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
            public final void onConfigChange() {
                LebaPluginQCircle$mQzoneConfigListener$2.b(LebaPluginQCircle.this);
            }
        };
    }
}
