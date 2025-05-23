package com.tencent.mobileqq.qqlive.sail.ui.game;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a.\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001\u001a&\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0000\u001a&\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t*\u00020\u0000\u001a&\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t*\u00020\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "Landroid/view/View;", "cardView", "", "taskStatus", "", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "btnView", "a", "g", "c", "j", "i", h.F, "k", "l", "f", "e", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/a$a", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.game.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8391a implements IDynamicParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameRecommendViewModel f272722a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f272723b;

        C8391a(GameRecommendViewModel gameRecommendViewModel, int i3) {
            this.f272722a = gameRecommendViewModel;
            this.f272723b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameRecommendViewModel, i3);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap<String, String> getDynamicParams(@Nullable String event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
            }
            return a.d(this.f272722a, this.f272723b);
        }
    }

    public static final void a(@NotNull GameRecommendViewModel gameRecommendViewModel, @NotNull View btnView) {
        String str;
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        if (gameRecommendViewModel.e2()) {
            str = "em_qqlive_gamecard_download_button";
        } else {
            str = "em_qqlive_gamecard_book_button";
        }
        String str2 = str;
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        aVar.b(btnView, true, null, str2, c(gameRecommendViewModel));
        aVar.h("imp", btnView, c(gameRecommendViewModel));
    }

    public static final void b(@NotNull GameRecommendViewModel gameRecommendViewModel, @NotNull View cardView, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        if (gameRecommendViewModel.e2()) {
            str = "em_qqlive_gamecard_download";
        } else {
            str = "em_qqlive_gamecard_book";
        }
        String str2 = str;
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        aVar.b(cardView, true, null, str2, d(gameRecommendViewModel, i3));
        aVar.h("imp", cardView, d(gameRecommendViewModel, i3));
        VideoReport.setEventDynamicParams(gameRecommendViewModel, new C8391a(gameRecommendViewModel, i3));
    }

    @NotNull
    public static final HashMap<String, String> c(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "1";
        if (gameRecommendViewModel.e2()) {
            hashMap.put("qqlive_gamecard_taskid", gameRecommendViewModel.d2());
            if (!gameRecommendViewModel.h2()) {
                if (gameRecommendViewModel.f2()) {
                    str = "2";
                } else {
                    str = "3";
                }
            }
            hashMap.put("qqlive_gamecard_downmode", str);
        } else {
            hashMap.put("qqlive_gamecard_taskid", gameRecommendViewModel.d2());
            if (!gameRecommendViewModel.f2()) {
                str = "2";
            }
            hashMap.put("qqlive_gamecard_bookmode", str);
        }
        return hashMap;
    }

    @NotNull
    public static final HashMap<String, String> d(@NotNull GameRecommendViewModel gameRecommendViewModel, int i3) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("qqlive_gamecard_taskid", gameRecommendViewModel.d2());
        if (gameRecommendViewModel.e2()) {
            hashMap.put("qqlive_gamecard_status", String.valueOf(i3));
        } else {
            hashMap.put("qqlive_gamecard_book_status", String.valueOf(i3));
        }
        return hashMap;
    }

    @NotNull
    public static final HashMap<String, String> e(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        HashMap<String, String> a16 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a.f(gameRecommendViewModel.getRoomId()).a();
        a16.put("dt_pgid", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
        a16.put("qqlive_gamecard_taskid", gameRecommendViewModel.d2());
        return a16;
    }

    @NotNull
    public static final HashMap<String, String> f(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        String str;
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        HashMap<String, String> e16 = e(gameRecommendViewModel);
        if (gameRecommendViewModel.h2()) {
            str = "1";
        } else {
            str = "2";
        }
        e16.put("qqlive_gamecard_downmode", str);
        return e16;
    }

    public static final void g(@NotNull GameRecommendViewModel gameRecommendViewModel, @NotNull View btnView) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.h("clck", btnView, c(gameRecommendViewModel));
    }

    public static final void h(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.i("ev_qqlive_gamecard_book_download_success", f(gameRecommendViewModel));
    }

    public static final void i(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.i("ev_qqlive_gamecard_book_install_success", f(gameRecommendViewModel));
    }

    public static final void j(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.i("ev_qqlive_gamecard_book_openapp", f(gameRecommendViewModel));
    }

    public static final void k(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.i("ev_qqlive_gamecard_download_start", f(gameRecommendViewModel));
    }

    public static final void l(@NotNull GameRecommendViewModel gameRecommendViewModel) {
        Intrinsics.checkNotNullParameter(gameRecommendViewModel, "<this>");
        HashMap<String, String> e16 = e(gameRecommendViewModel);
        e16.put("qqlive_gamecard_bookmode", "1");
        com.tencent.mobileqq.qqlive.sail.report.a.f272382a.i("ev_qqlive_gamecard_book_success", e16);
    }
}
