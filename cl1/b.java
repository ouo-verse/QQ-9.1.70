package cl1;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import dl1.b;
import dl1.c;
import dl1.f;
import dl1.g;
import dl1.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wk1.InputStyleConfig;
import wk1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006'"}, d2 = {"Lcl1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "", "hasMediaDraft", "", "l", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, h.F, "j", "k", "g", "init", "", "action", "", "msg", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakPermission", "e", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "hintTv", "Landroid/util/SparseArray;", "Ldl1/b;", "f", "Landroid/util/SparseArray;", "hintProcessorList", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", "<init>", "(Lwk1/h;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView hintTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SparseArray<dl1.b> hintProcessorList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SpeakPermissionType curSpeakPermission;

    public b(@NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
        this.curSpeakPermission = SpeakPermissionType.PERMISSION_TYPE_INVALID;
    }

    private final void g() {
        HashMap<String, Object> hashMap;
        Map<? extends String, ? extends Object> mapOf;
        TextView textView = this.hintTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
            textView = null;
        }
        if (o.a(textView)) {
            return;
        }
        e c16 = this.inputContext.c();
        if (c16 == null || (hashMap = c16.b()) == null) {
            hashMap = new HashMap<>();
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_click_region", 1));
        hashMap.putAll(mapOf);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        TextView textView3 = this.hintTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
        } else {
            textView2 = textView3;
        }
        iGuildDTReportApi.reportDtEventManual(textView2, "em_sgrp_forum_comment", "clck", hashMap);
        QLog.i("MainInputHintUI", 1, "handleCommentHintTvClick comment feed");
        this.inputContext.getDelegate().lh("message_comment_box_feed", new a.CommentFeedMessage("MainInputHintUI", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, 0, (short) 1, null, 16, null)));
    }

    private final void h(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.u1l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.comment_hint_tv)");
        this.hintTv = (TextView) findViewById;
        InputStyleConfig d16 = this.inputContext.d();
        TextView textView = null;
        if (d16 != null) {
            Integer hintTextColor = d16.getHintTextColor();
            if (hintTextColor != null) {
                int intValue = hintTextColor.intValue();
                TextView textView2 = this.hintTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                    textView2 = null;
                }
                textView2.setTextColor(intValue);
            }
            Drawable hintTextBackground = d16.getHintTextBackground();
            if (hintTextBackground != null) {
                TextView textView3 = this.hintTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                    textView3 = null;
                }
                textView3.setBackground(hintTextBackground);
            }
        }
        TextView textView4 = this.hintTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: cl1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.i(b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        Map mapOf;
        e c16 = this.inputContext.c();
        boolean z16 = false;
        if (c16 != null && c16.a()) {
            z16 = true;
        }
        if (z16) {
            TextView textView = this.hintTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                textView = null;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_click_region", 1));
            bt.d(textView, "em_sgrp_forum_comment", mapOf, ClickPolicy.REPORT_NONE, null, EndExposurePolicy.REPORT_NONE, 16, null);
        }
    }

    private final void k() {
        List<dl1.b> listOf;
        SparseArray<dl1.b> sparseArray = new SparseArray<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new dl1.b[]{new c(), new g(), new dl1.e(), new i(), new dl1.h(), new dl1.d(), new dl1.a(), new f()});
        for (dl1.b bVar : listOf) {
            sparseArray.put(bVar.a(), bVar);
        }
        this.hintProcessorList = sparseArray;
    }

    private final void l(boolean hasMediaDraft) {
        TextView textView = null;
        if (hasMediaDraft) {
            TextView textView2 = this.hintTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                textView2 = null;
            }
            TextView textView3 = this.hintTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
            } else {
                textView = textView3;
            }
            textView2.setText(textView.getContext().getResources().getString(R.string.f143950ng));
            return;
        }
        TextView textView4 = this.hintTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
            textView4 = null;
        }
        TextView textView5 = this.hintTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
        } else {
            textView = textView5;
        }
        textView4.setText(textView.getContext().getResources().getString(R.string.f144480ow));
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        d.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bVar) {
        d.a.c(this, bVar);
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_on_bottom_interact_exposure")) {
            e c16 = this.inputContext.c();
            if (c16 != null) {
                TextView textView = this.hintTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                    textView = null;
                }
                e.a.c(c16, textView, 1, null, 4, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, "message_update_hint_when_dismiss") && (msg2 instanceof Boolean)) {
            l(((Boolean) msg2).booleanValue());
        }
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermission) {
        Intrinsics.checkNotNullParameter(speakPermission, "speakPermission");
        this.curSpeakPermission = speakPermission;
        SparseArray<dl1.b> sparseArray = this.hintProcessorList;
        if (sparseArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintProcessorList");
            sparseArray = null;
        }
        dl1.b bVar = sparseArray.get(this.curSpeakPermission.ordinal());
        if (bVar != null) {
            TextView textView = this.hintTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                textView = null;
            }
            b.a.a(bVar, textView, null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        h(rootView);
        k();
        j();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean z16) {
        d.a.f(this, z16);
    }
}
