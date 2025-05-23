package do0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Ldo0/e;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Landroid/view/View;", "view", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", UserInfo.SEX_FEMALE, "", "t", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends t {
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void I(Ref.ObjectRef editText, View view) {
        EditText editText2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(editText, "$editText");
        try {
            T t16 = editText.element;
            if (t16 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText2 = null;
            } else {
                editText2 = (EditText) t16;
            }
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.d(Long.parseLong(editText2.getText().toString()), true));
        } catch (Exception unused) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.widget.TextView, T, android.view.View, android.widget.EditText] */
    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        EditText editText;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View decorView = ((Activity) context).getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "view.context as Activity).window.decorView");
        FrameLayout b16 = c.b((FrameLayout) decorView);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(0);
        ?? editText2 = new EditText(view.getContext());
        editText2.setInputType(2);
        editText2.setHint("\u8f93\u5165\u6d88\u606fseq");
        editText2.setHintTextColor(-7829368);
        editText2.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        editText2.setLayoutParams(layoutParams);
        objectRef.element = editText2;
        Button button = new Button(view.getContext());
        button.setOnClickListener(new View.OnClickListener() { // from class: do0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.I(Ref.ObjectRef.this, view2);
            }
        });
        button.setText("\u8df3 \u8f6c");
        button.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        T t16 = objectRef.element;
        EditText editText3 = null;
        if (t16 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        } else {
            editText = (EditText) t16;
        }
        linearLayout.addView(editText);
        linearLayout.addView(button);
        b16.addView(linearLayout, new ViewGroup.LayoutParams(-1, com.tencent.guild.aio.util.c.b(50)));
        T t17 = objectRef.element;
        if (t17 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            editText3 = (EditText) t17;
        }
        editText3.requestFocus();
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

    public /* synthetic */ e(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.chg, R.string.f16489272) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
