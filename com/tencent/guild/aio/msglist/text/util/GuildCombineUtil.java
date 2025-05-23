package com.tencent.guild.aio.msglist.text.util;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J`\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062>\u0010\u000f\u001a:\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\bH\u0002J \u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH\u0002J \u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH\u0002Jf\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00150\u00142!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00170\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\"J\"\u0010$\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010%\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010&\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u00101\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00105\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0014\u00107\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0014\u00108\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00100\u00a8\u0006;"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/GuildCombineUtil;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Landroid/widget/LinearLayout;", "contentAndReplyView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msgItem", "Landroid/view/View;", "Landroidx/lifecycle/Observer;", "Landroid/graphics/Bitmap;", "observerConstructor", "Lcom/tencent/guild/aio/msglist/text/util/c;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lkotlin/Function1;", "", "backgroundResProvider", "", "cornerRadiiProvider", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "root", "", "r", ReportConstant.COSTREPORT_PREFIX, "v", "Lcom/tencent/aio/data/msglist/a;", HippyTKDListViewAdapter.X, "t", "w", "u", "", "b", UserInfo.SEX_FEMALE, "PX_OF_8DP", "c", "PX_OF_4DP", "d", "PX_OF_2DP", "e", "[F", "SINGLE_MSG_BG_RADII", "f", "TOP_MSG_BG_RADII", "g", "BOTTOM_MSG_BG_RADII", tl.h.F, "MIDDLE_MSG_BG_RADII", "DEFAULT_MSG_BG_RADII", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildCombineUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildCombineUtil f111919a = new GuildCombineUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float PX_OF_8DP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final float PX_OF_4DP;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final float PX_OF_2DP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] SINGLE_MSG_BG_RADII;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] TOP_MSG_BG_RADII;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] BOTTOM_MSG_BG_RADII;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] MIDDLE_MSG_BG_RADII;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] DEFAULT_MSG_BG_RADII;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/text/util/GuildCombineUtil$a", "Lcom/tencent/guild/aio/msglist/text/util/j;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "closure", "value", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends j<View, Bitmap> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i<Bitmap> f111928e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<GuildMsgItem, Integer> f111929f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function1<GuildMsgItem, float[]> f111930h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(View view, i<Bitmap> iVar, Function1<? super GuildMsgItem, Integer> function1, Function1<? super GuildMsgItem, float[]> function12) {
            super(view);
            this.f111928e = iVar;
            this.f111929f = function1;
            this.f111930h = function12;
        }

        @Override // com.tencent.guild.aio.msglist.text.util.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull View closure, @Nullable Bitmap value) {
            GuildMsgItem guildMsgItem;
            Intrinsics.checkNotNullParameter(closure, "closure");
            Object payload = this.f111928e.getPayload();
            if (payload instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) payload;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem == null) {
                return;
            }
            if (value != null) {
                com.tencent.guild.aio.msglist.text.util.b bVar = new com.tencent.guild.aio.msglist.text.util.b(value);
                bVar.b(this.f111930h.invoke(guildMsgItem));
                closure.setBackground(bVar);
                return;
            }
            closure.setBackgroundResource(this.f111929f.invoke(guildMsgItem).intValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/aio/msglist/text/util/GuildCombineUtil$b", "Lcom/tencent/guild/aio/msglist/text/util/j;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "Lcom/tencent/guild/aio/msglist/text/util/c;", "closure", "value", "", "b", "detach", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends j<View, Bitmap> implements c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveData<Bitmap> f111931e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view, LiveData<Bitmap> liveData) {
            super(view);
            this.f111931e = liveData;
        }

        @Override // com.tencent.guild.aio.msglist.text.util.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull View closure, @Nullable Bitmap value) {
            Intrinsics.checkNotNullParameter(closure, "closure");
            if (value != null) {
                com.tencent.guild.aio.msglist.text.util.b bVar = new com.tencent.guild.aio.msglist.text.util.b(value);
                bVar.b(GuildCombineUtil.SINGLE_MSG_BG_RADII);
                closure.setBackground(bVar);
                return;
            }
            closure.setBackgroundResource(R.drawable.guild_aio_friend_bubble_bg);
        }

        @Override // com.tencent.guild.aio.msglist.text.util.c
        public void detach() {
            this.f111931e.removeObserver(this);
        }
    }

    static {
        float dpToPx = ViewUtils.dpToPx(8.0f);
        PX_OF_8DP = dpToPx;
        float dpToPx2 = ViewUtils.dpToPx(4.0f);
        PX_OF_4DP = dpToPx2;
        float dpToPx3 = ViewUtils.dpToPx(2.0f);
        PX_OF_2DP = dpToPx3;
        SINGLE_MSG_BG_RADII = new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx};
        TOP_MSG_BG_RADII = new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx3, dpToPx3};
        BOTTOM_MSG_BG_RADII = new float[]{dpToPx3, dpToPx3, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx};
        MIDDLE_MSG_BG_RADII = new float[]{dpToPx3, dpToPx3, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx3, dpToPx3};
        DEFAULT_MSG_BG_RADII = new float[]{dpToPx2, dpToPx2, dpToPx2, dpToPx2, dpToPx2, dpToPx2, dpToPx2, dpToPx2};
    }

    GuildCombineUtil() {
    }

    private final c i(GuildMsgItem currentMsgItem, LinearLayout contentAndReplyView, LifecycleOwner lifecycleOwner, Function2<? super GuildMsgItem, ? super View, ? extends Observer<Bitmap>> observerConstructor) {
        final LiveData<Bitmap> c16 = f.f111944a.c(currentMsgItem.isSelf());
        final Object tag = contentAndReplyView.getTag(R.id.w17);
        if (tag instanceof i) {
            i iVar = (i) tag;
            c16.removeObserver(iVar);
            iVar.c(currentMsgItem);
            c16.observe(lifecycleOwner, iVar);
            return new c() { // from class: com.tencent.guild.aio.msglist.text.util.g
                @Override // com.tencent.guild.aio.msglist.text.util.c
                public final void detach() {
                    GuildCombineUtil.j(LiveData.this, tag);
                }
            };
        }
        final Observer<Bitmap> invoke = observerConstructor.invoke(currentMsgItem, contentAndReplyView);
        contentAndReplyView.setTag(R.id.w17, invoke);
        c16.observe(lifecycleOwner, invoke);
        return new c() { // from class: com.tencent.guild.aio.msglist.text.util.h
            @Override // com.tencent.guild.aio.msglist.text.util.c
            public final void detach() {
                GuildCombineUtil.k(LiveData.this, invoke);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(LiveData resLiveData, Object obj) {
        Intrinsics.checkNotNullParameter(resLiveData, "$resLiveData");
        resLiveData.removeObserver((Observer) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LiveData resLiveData, Observer newObserver) {
        Intrinsics.checkNotNullParameter(resLiveData, "$resLiveData");
        Intrinsics.checkNotNullParameter(newObserver, "$newObserver");
        resLiveData.removeObserver(newObserver);
    }

    private final Observer<Bitmap> l(GuildMsgItem msgItem, View contentAndReplyView, Function1<? super GuildMsgItem, Integer> backgroundResProvider, Function1<? super GuildMsgItem, float[]> cornerRadiiProvider) {
        i iVar = new i(msgItem, null);
        iVar.b(new a(contentAndReplyView, iVar, backgroundResProvider, cornerRadiiProvider));
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] m(GuildMsgItem msgItem) {
        boolean isLastMsgNeedCombine = msgItem.getIsLastMsgNeedCombine();
        boolean isNeedCombine = msgItem.getIsNeedCombine();
        if (isLastMsgNeedCombine) {
            if (isNeedCombine) {
                return MIDDLE_MSG_BG_RADII;
            }
            return TOP_MSG_BG_RADII;
        }
        if (isNeedCombine) {
            return BOTTOM_MSG_BG_RADII;
        }
        return SINGLE_MSG_BG_RADII;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(GuildMsgItem msgItem) {
        boolean isLastMsgNeedCombine = msgItem.getIsLastMsgNeedCombine();
        boolean isSelf = msgItem.isSelf();
        boolean isNeedCombine = msgItem.getIsNeedCombine();
        if (isLastMsgNeedCombine) {
            if (isSelf) {
                if (isNeedCombine) {
                    return R.drawable.guild_self_sent_msg_bubble_middle_bg_selector;
                }
                return R.drawable.guild_self_sent_msg_bubble_top_bg_selector;
            }
            if (isNeedCombine) {
                return R.drawable.guild_msg_bubble_middle_bg_selector;
            }
            return R.drawable.guild_msg_bubble_top_bg_selector;
        }
        if (isSelf) {
            if (isNeedCombine) {
                return R.drawable.guild_self_sent_msg_bubble_bottom_bg_selector;
            }
            return R.drawable.guild_aio_self_bubble_bg;
        }
        if (isNeedCombine) {
            return R.drawable.guild_msg_bubble_bottom_bg_selector;
        }
        return R.drawable.guild_aio_friend_bubble_bg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observer<Bitmap> o(GuildMsgItem msgItem, View contentAndReplyView) {
        return l(msgItem, contentAndReplyView, new GuildCombineUtil$getMixBubbleBackgroundColorResObserver$1(this), new GuildCombineUtil$getMixBubbleBackgroundColorResObserver$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int p(GuildMsgItem currentMsgItem) {
        if (currentMsgItem.getIsLastMsgNeedCombine()) {
            if (currentMsgItem.getIsNeedCombine()) {
                return R.drawable.guild_msg_bubble_middle_bg_selector;
            }
            return R.drawable.guild_msg_bubble_top_bg_selector;
        }
        if (currentMsgItem.getIsNeedCombine()) {
            return R.drawable.guild_msg_bubble_bottom_bg_selector;
        }
        return R.drawable.guild_aio_friend_bubble_bg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observer<Bitmap> q(GuildMsgItem msgItem, View contentAndReplyView) {
        return l(msgItem, contentAndReplyView, new GuildCombineUtil$getTextBubbleBackgroundColorResObserver$1(this), new GuildCombineUtil$getTextBubbleBackgroundColorResObserver$2(this));
    }

    private final void r(View root) {
        ConstraintLayout constraintLayout;
        if (root instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) root;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout != null) {
            constraintLayout.setPadding(0, 0, 0, 0);
        }
        FrameLayout frameLayout = (FrameLayout) root.findViewById(R.id.zfr);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.zg8);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void s(View root) {
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;
        FrameLayout frameLayout;
        LinearLayout linearLayout2;
        if (root instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) root;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout != null) {
            constraintLayout.setPadding(0, constraintLayout.getContext().getResources().getDimensionPixelSize(R.dimen.f158713n2), 0, 0);
        }
        if (root != null && (linearLayout2 = (LinearLayout) root.findViewById(R.id.f166331zg3)) != null) {
            linearLayout2.setVisibility(0);
        }
        if (root != null && (frameLayout = (FrameLayout) root.findViewById(R.id.zfr)) != null) {
            frameLayout.setVisibility(0);
        }
        if (root != null && (linearLayout = (LinearLayout) root.findViewById(R.id.zg8)) != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Nullable
    public final c t(@Nullable View root, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull LifecycleOwner lifecycleOwner) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        if (root != null) {
            linearLayout = (LinearLayout) root.findViewById(R.id.f164907u83);
        } else {
            linearLayout = null;
        }
        if (linearLayout == null) {
            return null;
        }
        return i(guildMsgItem, linearLayout, lifecycleOwner, new GuildCombineUtil$handleCombineMsgBg$1(this));
    }

    public final void u(@NotNull View root, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getIsNeedCombine()) {
            r(root);
        } else {
            s(root);
        }
    }

    @NotNull
    public final c v(@NotNull View contentAndReplyView, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(contentAndReplyView, "contentAndReplyView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LiveData<Bitmap> obtainBubbleDrawableBitmap = ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).obtainBubbleDrawableBitmap(f.f111944a.p(false));
        Object tag = contentAndReplyView.getTag(R.id.w17);
        if ((tag instanceof Observer) && (tag instanceof c)) {
            Observer<? super Bitmap> observer = (Observer) tag;
            obtainBubbleDrawableBitmap.removeObserver(observer);
            obtainBubbleDrawableBitmap.observe(lifecycleOwner, observer);
            return (c) tag;
        }
        b bVar = new b(contentAndReplyView, obtainBubbleDrawableBitmap);
        contentAndReplyView.setTag(R.id.w17, bVar);
        obtainBubbleDrawableBitmap.observe(lifecycleOwner, bVar);
        return bVar;
    }

    @Nullable
    public final c w(@Nullable View root, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull LifecycleOwner lifecycleOwner) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        if (root != null) {
            linearLayout = (LinearLayout) root.findViewById(R.id.f164907u83);
        } else {
            linearLayout = null;
        }
        if (linearLayout == null) {
            return null;
        }
        return i(guildMsgItem, linearLayout, lifecycleOwner, new GuildCombineUtil$handleMixBubbleCombineMsgBg$1(this));
    }

    public final void x(@NotNull View root, @NotNull com.tencent.aio.data.msglist.a msgItem) {
        float[] fArr;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        if (guildMsgItem.getIsLastMsgNeedCombine()) {
            if (guildMsgItem.getIsNeedCombine()) {
                fArr = MIDDLE_MSG_BG_RADII;
            } else {
                fArr = TOP_MSG_BG_RADII;
            }
        } else if (guildMsgItem.getIsNeedCombine()) {
            fArr = BOTTOM_MSG_BG_RADII;
        } else {
            fArr = SINGLE_MSG_BG_RADII;
        }
        guildMsgItem.setRadii(fArr);
    }
}
