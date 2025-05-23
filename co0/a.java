package co0;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.aio.halfpop.c;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.aio.reserve2.busi.chosen.d;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00060\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0019"}, d2 = {"Lco0/a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "msg", "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/halfpop/menu/n;", "list", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "a", "Lcom/tencent/aio/data/msglist/a;", "Landroid/view/View;", "view", "", "f", "d", "e", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d$a;", "c", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f31161a = new a();

    a() {
    }

    private final void a(FragmentManager fragmentManager, Object msg2, List<? extends Class<? extends n<? extends Object>>> list, com.tencent.aio.api.runtime.a aioContext) {
        if (fragmentManager.isStateSaved()) {
            QLog.e("FileUtil", 1, "fragmentManager.isStateSaved");
            return;
        }
        try {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(b.b(b.f31162a, list, msg2, aioContext, false, 8, null));
            baseBottomSheetDialog.uh(0.5f);
            baseBottomSheetDialog.vh(true);
            baseBottomSheetDialog.th(R.drawable.guild_aio_pop_menu_shape);
            baseBottomSheetDialog.setCancelable(true);
            if (fragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(fragmentManager, "BaseBottomSheetDialog");
            }
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, String.valueOf(e16));
        }
    }

    public final void b(@NotNull FragmentManager fragmentManager, @NotNull com.tencent.aio.data.msglist.a msg2, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (fragmentManager.isStateSaved()) {
            QLog.e("FileUtil", 1, "fragmentManager.isStateSaved");
            return;
        }
        try {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(b.b(b.f31162a, c.f110667a.c(), msg2, aioContext, false, 8, null));
            baseBottomSheetDialog.uh(0.5f);
            baseBottomSheetDialog.th(R.drawable.guild_aio_pop_menu_shape);
            baseBottomSheetDialog.setCancelable(true);
            if (fragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(fragmentManager, "BaseBottomSheetDialog");
            }
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, String.valueOf(e16));
        }
    }

    public final void c(@NotNull FragmentManager fragmentManager, @NotNull d.ChosenParams msg2, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        a(fragmentManager, msg2, c.f110667a.e(), aioContext);
    }

    public final boolean d(@NotNull FragmentManager fragmentManager, @NotNull com.tencent.aio.data.msglist.a msg2, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View view) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(view, "view");
        if (fragmentManager.isStateSaved()) {
            QLog.e("FileUtil", 1, "fragmentManager.isStateSaved");
            return false;
        }
        try {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.wh(view);
            baseBottomSheetDialog.yh(b.b(b.f31162a, c.f110667a.b(), msg2, aioContext, false, 8, null));
            baseBottomSheetDialog.uh(0.5f);
            baseBottomSheetDialog.th(R.drawable.guild_aio_pop_menu_shape);
            baseBottomSheetDialog.setCancelable(true);
            if (fragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(fragmentManager, "BaseBottomSheetDialog");
            }
            return true;
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, String.valueOf(e16));
            return false;
        }
    }

    public final void e(@NotNull FragmentManager fragmentManager, @NotNull com.tencent.aio.data.msglist.a msg2, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (fragmentManager.isStateSaved()) {
            QLog.e("FileUtil", 1, "fragmentManager.isStateSaved");
            return;
        }
        try {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(b.f31162a.a(c.f110667a.d(), msg2, aioContext, false));
            baseBottomSheetDialog.uh(0.5f);
            baseBottomSheetDialog.vh(true);
            baseBottomSheetDialog.th(R.drawable.guild_aio_pop_menu_shape);
            baseBottomSheetDialog.setCancelable(true);
            if (fragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(fragmentManager, "BaseBottomSheetDialog");
            }
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, String.valueOf(e16));
        }
    }

    public final boolean f(@NotNull FragmentManager fragmentManager, @NotNull com.tencent.aio.data.msglist.a msg2, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull View view) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(view, "view");
        if (fragmentManager.isStateSaved()) {
            QLog.e("FileUtil", 1, "fragmentManager.isStateSaved");
            return false;
        }
        try {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.wh(view);
            baseBottomSheetDialog.yh(b.b(b.f31162a, c.f110667a.f(), msg2, aioContext, false, 8, null));
            baseBottomSheetDialog.uh(0.5f);
            baseBottomSheetDialog.th(R.drawable.guild_aio_pop_menu_shape);
            baseBottomSheetDialog.setCancelable(true);
            if (fragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(fragmentManager, "BaseBottomSheetDialog");
            }
            return true;
        } catch (Exception e16) {
            QLog.e("FileUtil", 1, String.valueOf(e16));
            return false;
        }
    }
}
