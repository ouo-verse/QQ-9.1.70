package ct0;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.q;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007\u00a8\u0006\r"}, d2 = {"Lct0/a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Lcom/tencent/guild/aio/halfpop/menu/n;", VideoTemplateParser.ITEM_LIST, "Landroid/view/View;", "targetView", "", "a", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ void b(a aVar, com.tencent.aio.api.runtime.a aVar2, List list, View view, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            view = null;
        }
        aVar.a(aVar2, list, view);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull List<? extends n<Object>> itemList, @Nullable View targetView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        if (targetView != null) {
            targetView.setSelected(true);
        }
        FragmentManager parentFragmentManager = aioContext.c().getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "aioContext.fragment.parentFragmentManager");
        BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
        baseBottomSheetDialog.wh(targetView);
        baseBottomSheetDialog.yh(itemList);
        baseBottomSheetDialog.th(R.drawable.guild_media_aio_msgmenu_bg_dark);
        baseBottomSheetDialog.zh(1002);
        p pVar = new p();
        pVar.d(Integer.valueOf(R.color.f157149br0));
        q qVar = new q();
        qVar.f(Integer.valueOf(R.drawable.guild_live_chatpie_menu_item_selector));
        qVar.e(new PorterDuffColorFilter(aioContext.c().getResources().getColor(R.color.f157150br1), PorterDuff.Mode.SRC_ATOP));
        Unit unit = Unit.INSTANCE;
        baseBottomSheetDialog.xh(new s(pVar, qVar, null, 4, null));
        if (parentFragmentManager.isStateSaved()) {
            QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
        } else {
            baseBottomSheetDialog.show(parentFragmentManager, "BaseBottomSheetDialog");
        }
    }
}
