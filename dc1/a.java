package dc1;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a extends e {

    /* renamed from: g, reason: collision with root package name */
    private QQAppInterface f393533g;

    /* renamed from: h, reason: collision with root package name */
    private Context f393534h;

    public a(QQAppInterface qQAppInterface, Context context) {
        this.f393534h = context;
        this.f393533g = qQAppInterface;
    }

    @Override // dc1.e
    public boolean b() {
        int p16;
        SessionInfo sessionInfo;
        String m3 = m();
        long o16 = o();
        if (FileUtils.fileExistsAndNotEmpty(n()) || (p16 = p()) == 2 || (((sessionInfo = this.f393561b) != null && sessionInfo.f179555d == 1 && p16 == 8) || FileManagerUtil.getFileType(m3) != 2 || !FileManagerUtil.is2GOr3G())) {
            return false;
        }
        if ((TextUtils.isEmpty(m3) || o16 <= 0 || o16 <= ((IQFileConfigManager) this.f393533g.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(m3)).f207738b) && o16 <= 1048576) {
            return false;
        }
        return true;
    }

    @Override // dc1.e
    public ChatMessage c() {
        return this.f393560a;
    }

    @Override // dc1.e
    public SessionInfo e() {
        return this.f393561b;
    }

    @Override // dc1.e
    public boolean f() {
        return this.f393565f;
    }

    @Override // dc1.e
    public boolean g() {
        return this.f393562c;
    }

    protected abstract String m();

    protected abstract String n();

    protected abstract long o();

    protected abstract int p();

    public void q(ChatMessage chatMessage) {
        this.f393560a = chatMessage;
    }

    public void r(boolean z16) {
        this.f393565f = z16;
    }

    public void s(boolean z16) {
        this.f393562c = z16;
    }

    public void t(boolean z16) {
        this.f393563d = z16;
    }

    public void u(SessionInfo sessionInfo) {
        this.f393561b = sessionInfo;
    }
}
