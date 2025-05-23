package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/business/MsfUdpConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/config/business/aa;", "c", "", "content", "f", DownloadInfo.spKey_Config, "", "d", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MsfUdpConfigParser extends BaseConfigParser<aa> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(aa aaVar, AppRuntime appRuntime) {
        QLog.d("MsfUdpConfigParser", 1, "[doOnConfigUpdate]: " + aaVar.getConfigStr());
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
        newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, aaVar.getConfigStr());
        newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_UDP_CONFIG_MANAGER);
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aa defaultConfig() {
        return new aa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable final aa config) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (config != null && peekAppRuntime != null && !TextUtils.isEmpty(config.getConfigStr())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.ab
                @Override // java.lang.Runnable
                public final void run() {
                    MsfUdpConfigParser.e(aa.this, peekAppRuntime);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public aa parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        aa aaVar = new aa();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            aaVar.b(new String(content, UTF_8));
            QLog.d("MsfUdpConfigParser", 1, "configs parse\uff1a" + aaVar.getConfigStr());
        }
        return aaVar;
    }
}
