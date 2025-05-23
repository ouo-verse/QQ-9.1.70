package do0;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0015"}, d2 = {"Ldo0/a;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Landroid/content/Context;", "context", "", "text", "", "H", "Landroid/view/View;", "view", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", UserInfo.SEX_FEMALE, "", "t", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends t {
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void H(Context context, String text) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, text));
        QQToast.makeText(context, "\u5df2\u590d\u5236debug\u4fe1\u606f!", 0).show();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            H(context, MsgExtKt.g(data.getMsgRecord()));
            Context context2 = view.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            View decorView = ((Activity) context2).getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) decorView;
            FrameLayout b16 = c.b(frameLayout);
            TextView textView = new TextView(frameLayout.getContext());
            textView.setId(R.id.beb);
            textView.setTextColor(-1);
            textView.setTextIsSelectable(true);
            textView.setText(MsgExtKt.g(data.getMsgRecord()) + data.getExtJsonObject());
            b16.addView(textView);
            textView.requestFocus();
        }
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (super.a(data) && !((IAppSetting) QRoute.api(IAppSetting.class)).mo112public()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ a(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.chg, R.string.f16488271) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
