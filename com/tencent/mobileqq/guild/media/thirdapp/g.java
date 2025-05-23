package com.tencent.mobileqq.guild.media.thirdapp;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/g;", "", "", "b", "c", "", "d", "", "e", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f229539a = new g();

    g() {
    }

    private final boolean b() {
        return j.c().getSelfUserInfo().f228100h;
    }

    public final boolean c() {
        int d16 = d();
        boolean z16 = false;
        if (d16 != -2) {
            if (d16 != -1) {
                if (d16 == 0) {
                    z16 = true;
                }
            } else {
                g();
            }
        } else {
            e();
        }
        Logger.f235387a.d().d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkUserCanStartThirdApp permission " + z16);
        return z16;
    }

    public final int d() {
        boolean z16;
        Integer num;
        String E = j.a().E();
        String guildID = j.a().getGuildID();
        if (!ch.m0(guildID) && !ch.h0(E)) {
            if (!GuildMediaUtils.k(guildID, E)) {
                Logger.f235387a.d().i("ThirdAppPermissionUtils", 1, "checkUserCanCloseThirdApp: no activity permission.");
                return -1;
            }
            IGProLobbyStateInfo lobbyRoomInfo = j.a().d0().getLobbyRoomInfo();
            if (lobbyRoomInfo != null && (lobbyRoomInfo.getLobbyRoomCurrUserNum() > 1 || (lobbyRoomInfo.getLobbyRoomCurrUserNum() == 1 && !b()))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return 0;
            }
            Logger.a d16 = Logger.f235387a.d();
            if (lobbyRoomInfo != null) {
                num = Integer.valueOf(lobbyRoomInfo.getLobbyRoomCurrUserNum());
            } else {
                num = null;
            }
            d16.i("ThirdAppPermissionUtils", 1, "checkUserCanCloseThirdApp: other user in room. count[" + num + "] hasOthersInApp " + z16);
            return -2;
        }
        Logger.f235387a.d().i("ThirdAppPermissionUtils", 1, "checkUserCanCloseThirdApp: self is manager.");
        return 0;
    }

    public final void e() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, BaseApplication.getContext().getText(R.string.f1499513o), (String) null, qBaseActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.thirdapp.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.f(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void g() {
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.f1499913s, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DialogInterface dialogInterface, int i3) {
    }
}
