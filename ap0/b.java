package ap0;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.at.utils.h;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.api.IRobotSlashApi;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.robot.slash.manager.d f26647a;

    /* renamed from: b, reason: collision with root package name */
    public GuildAIOInputEditText f26648b = null;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f26649c = null;

    /* renamed from: d, reason: collision with root package name */
    private Context f26650d = null;

    /* renamed from: e, reason: collision with root package name */
    private AIOParam f26651e = null;

    /* renamed from: f, reason: collision with root package name */
    private final h f26652f = new h() { // from class: ap0.a
        @Override // com.tencent.guild.aio.input.at.utils.h
        public final boolean a(KeyEvent keyEvent) {
            boolean f16;
            f16 = b.this.f(keyEvent);
            return f16;
        }
    };

    private void c(String str, int i3, int i16, int i17) {
        if (str.startsWith("/") && !so0.e.a(this.f26648b.getEditableText()) && !str.contains("\n") && !str.contains("#") && !com.tencent.mobileqq.guild.robot.utils.a.b(str, this.f26648b) && !com.tencent.mobileqq.guild.robot.utils.a.e(str, this.f26648b) && !com.tencent.mobileqq.guild.robot.utils.a.d(str)) {
            if (TextUtils.equals(str, "/")) {
                f.isSlashListeningBlocked = false;
                f.firstSpanEnd = -1;
                f.robotFunctionPanelBlockTime = 0;
            }
            if (f.isSlashListeningBlocked) {
                return;
            }
            this.f26647a.g(str.substring(0, this.f26648b.getSelectionStart()).trim().replaceFirst("/", ""));
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setRobotSlashPanelUsed();
            return;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean f(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 4) {
            return b();
        }
        return false;
    }

    public boolean b() {
        com.tencent.robot.slash.manager.d dVar = this.f26647a;
        if (dVar != null) {
            if (dVar.a()) {
                this.f26647a.e();
                this.f26647a.b(false);
                return true;
            }
            this.f26647a.e();
            this.f26647a.b(false);
        }
        return false;
    }

    public void d(ViewGroup viewGroup, AIOParam aIOParam, boolean z16, com.tencent.aio.api.runtime.a aVar) {
        if (aVar != null && aIOParam != null && !com.tencent.guild.aio.util.a.j(aIOParam) && !com.tencent.guild.aio.util.a.l(aIOParam)) {
            this.f26649c = viewGroup;
            this.f26648b = (GuildAIOInputEditText) viewGroup.findViewById(R.id.vxk);
            this.f26650d = viewGroup.getContext();
            this.f26651e = aIOParam;
            f.guildSlashHelper = this;
            this.f26648b.setKeyEventPreImeListener("GuildSlashHelper", this.f26652f);
            if (this.f26647a == null) {
                this.f26647a = ((IRobotSlashApi) QRoute.api(IRobotSlashApi.class)).createSlashManagerFromAIO(aVar, viewGroup);
            }
        }
    }

    public boolean e() {
        com.tencent.robot.slash.manager.d dVar = this.f26647a;
        if (dVar != null && dVar.r()) {
            return true;
        }
        return false;
    }

    public void g() {
        AIOParam aIOParam = this.f26651e;
        if (aIOParam != null && !com.tencent.guild.aio.util.a.j(aIOParam) && !com.tencent.guild.aio.util.a.l(this.f26651e)) {
            f.guildSlashHelper = null;
            GuildAIOInputEditText guildAIOInputEditText = this.f26648b;
            if (guildAIOInputEditText != null) {
                guildAIOInputEditText.setKeyEventPreImeListener("GuildSlashHelper", null);
            }
            com.tencent.robot.slash.manager.d dVar = this.f26647a;
            if (dVar != null) {
                dVar.onDestroy();
                this.f26647a = null;
            }
            this.f26648b = null;
            this.f26649c = null;
            this.f26650d = null;
            this.f26651e = null;
        }
    }

    public void h(CharSequence charSequence, int i3, int i16, int i17) {
        QLog.i("GuildRobotTag:GuildSlashHelper", 1, "onTextChanged, inputLength" + charSequence.length());
        if (this.f26647a != null) {
            c(charSequence.toString(), i3, i16, i17);
        }
    }
}
