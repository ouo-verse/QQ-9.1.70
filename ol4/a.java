package ol4;

import android.content.Context;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import nl4.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lol4/a;", "Lnl4/c;", "Lnl4/a;", "checkMicPermissionCallback", "", "k2", "Landroid/content/Context;", "context", "init", "o2", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"ol4/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ol4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10923a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nl4.a f423098a;

        C10923a(nl4.a aVar) {
            this.f423098a = aVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            nl4.a aVar = this.f423098a;
            if (aVar != null) {
                aVar.a(true);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            nl4.a aVar = this.f423098a;
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    @Override // nl4.c
    public void k2(@Nullable nl4.a checkMicPermissionCallback) {
        boolean z16;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(Foreground.getTopActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LIVE, QQPermissionConstants.Business.SCENE.QQ_TIMI_GAME_TOGETHER_PLAY));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (checkMicPermissionCallback != null) {
                checkMicPermissionCallback.a(true);
            }
        } else {
            l.h("MicServiceImpl", 1, "checkMicPermission");
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new C10923a(checkMicPermissionCallback));
        }
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
