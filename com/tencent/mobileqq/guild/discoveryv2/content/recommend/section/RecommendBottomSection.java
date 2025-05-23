package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendLiveData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendScreenShareData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001j\u0002`\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J,\u0010\u001e\u001a\u00020\u00062\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014J\u0016\u0010!\u001a\u00020\u00062\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\nR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendBottomSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendCommonSection;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "guidInfo", "", BdhLogUtil.LogTag.Tag_Conn, "", "guildName", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalList", HippyTKDListViewAdapter.X, "Lcom/tencent/image/URLDrawable;", "urlDrawable", "Landroid/widget/TextView;", "nameView", "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "labels", "y", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mGuildAvatar", "f", "Landroid/widget/TextView;", "mGuildName", tl.h.F, "mGuildDesc", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendBottomSection extends ar<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l<?>> {

    @NotNull
    private static final Lazy<String> C;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final int f217175m = QQGuildUIUtil.f(12.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mGuildAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mGuildName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mGuildDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendBottomSection$a;", "", "", "PREFER_CLICKED_ANIM_JSON$delegate", "Lkotlin/Lazy;", "a", "()Ljava/lang/String;", "PREFER_CLICKED_ANIM_JSON", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendBottomSection$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return (String) RecommendBottomSection.C.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendBottomSection$Companion$PREFER_CLICKED_ANIM_JSON$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return ((IGuildFeedConfigAPi) QRoute.api(IGuildFeedConfigAPi.class)).getPreferClickedAnimJsonPath();
            }
        });
        C = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(URLDrawable urlDrawable, TextView nameView) {
        nameView.setCompoundDrawables(null, null, urlDrawable, null);
        nameView.setCompoundDrawablePadding(com.tencent.mobileqq.guild.util.an.INSTANCE.b());
    }

    private final void C(final IGProFeedGuildInfo guidInfo) {
        ImageView imageView = this.mGuildAvatar;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
            imageView = null;
        }
        imageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        ImageView imageView3 = this.mGuildAvatar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
        } else {
            imageView2 = imageView3;
        }
        imageView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.i
            @Override // java.lang.Runnable
            public final void run() {
                RecommendBottomSection.D(IGProFeedGuildInfo.this, this);
            }
        });
        String guildName = guidInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guidInfo.guildName");
        x(guildName, guidInfo.getMedals());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(IGProFeedGuildInfo guidInfo, RecommendBottomSection this$0) {
        Intrinsics.checkNotNullParameter(guidInfo, "$guidInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String guildIcon = guidInfo.getGuildIcon();
        ImageView imageView = this$0.mGuildAvatar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
            imageView = null;
        }
        com.tencent.mobileqq.guild.u.q(guildIcon, imageView, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[EDGE_INSN: B:15:0x004a->B:16:0x004a BREAK  A[LOOP:0: B:7:0x002a->B:33:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:7:0x002a->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x(String guildName, List<? extends IGProMedalInfo> medalList) {
        CharSequence trim;
        IGProMedalInfo iGProMedalInfo;
        Object obj;
        boolean z16;
        String a16 = com.tencent.mobileqq.guild.util.az.a(guildName);
        Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildName)");
        trim = StringsKt__StringsKt.trim((CharSequence) a16);
        String obj2 = trim.toString();
        TextView textView = this.mGuildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            textView = null;
        }
        textView.setText(obj2);
        if (medalList != null) {
            Iterator<T> it = medalList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) obj).getOfficialMedalInfoExt();
                    if (officialMedalInfoExt != null) {
                        z16 = true;
                        if (officialMedalInfoExt.getIsOffical()) {
                            if (!z16) {
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            iGProMedalInfo = (IGProMedalInfo) obj;
        } else {
            iGProMedalInfo = null;
        }
        if (iGProMedalInfo == null) {
            TextView textView3 = this.mGuildName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
                textView3 = null;
            }
            textView3.setCompoundDrawablePadding(0);
            TextView textView4 = this.mGuildName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
                textView4 = null;
            }
            textView4.setCompoundDrawables(null, null, null, null);
            return;
        }
        TextView textView5 = this.mGuildName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
        } else {
            textView2 = textView5;
        }
        com.tencent.mobileqq.guild.util.an.INSTANCE.e(new WeakReference<>(textView2), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendBottomSection$bindGuildNameAndMedal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                invoke(uRLDrawable, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                TextView textView6;
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                RecommendBottomSection recommendBottomSection = RecommendBottomSection.this;
                textView6 = recommendBottomSection.mGuildName;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
                    textView6 = null;
                }
                recommendBottomSection.B(urlDrawable, textView6);
            }
        }, f217175m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(RecommendBottomSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mGuildDesc;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            textView = null;
        }
        if (textView.getWidth() < this$0.getRootView().getWidth() * 0.35d) {
            TextView textView3 = this$0.mGuildDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l<?> data, int position, @Nullable List<Object> payload) {
        boolean z16;
        IGProFeedGuildInfo iGProFeedGuildInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        List<Object> list = payload;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        if (data instanceof RecommendScreenShareData) {
            iGProFeedGuildInfo = ((RecommendScreenShareData) data).getRecommendItem().getContentRecommendVoice().getGuildInfo();
        } else if (data instanceof RecommendLiveData) {
            iGProFeedGuildInfo = ((RecommendLiveData) data).getRecommendItem().getContentRecommendLive().getGuildInfo();
        } else if (data instanceof RecommendAbsFeedData) {
            RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) data;
            ArrayList<IGProGuildLabel> tags = recommendAbsFeedData.getTags();
            Intrinsics.checkNotNullExpressionValue(tags, "data.tags");
            y(tags);
            iGProFeedGuildInfo = recommendAbsFeedData.getGuildInfo();
        } else {
            iGProFeedGuildInfo = null;
        }
        if (iGProFeedGuildInfo != null) {
            C(iGProFeedGuildInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5k};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165469w54);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026very_bottom_guild_avatar)");
        this.mGuildAvatar = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w56);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026covery_bottom_guild_name)");
        this.mGuildName = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.w55);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026covery_bottom_guild_desc)");
        this.mGuildDesc = (TextView) findViewById3;
        TextView textView = this.mGuildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            textView = null;
        }
        TextView textView3 = this.mGuildName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            textView3 = null;
        }
        textView.setTextColor(textView3.getResources().getColorStateList(R.color.qui_common_text_secondary));
        TextView textView4 = this.mGuildDesc;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            textView4 = null;
        }
        TextView textView5 = this.mGuildDesc;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
        } else {
            textView2 = textView5;
        }
        textView4.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_secondary));
    }

    public final void y(@NotNull List<? extends IGProGuildLabel> labels) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(labels, "labels");
        TextView textView = this.mGuildDesc;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            textView = null;
        }
        textView.setVisibility(8);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) labels);
        IGProGuildLabel iGProGuildLabel = (IGProGuildLabel) firstOrNull;
        if (iGProGuildLabel == null) {
            return;
        }
        TextView textView3 = this.mGuildDesc;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            textView3 = null;
        }
        byte[] labelName = iGProGuildLabel.getLabelName();
        Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
        textView3.setText(APLogFileUtil.SEPARATOR_LOG + new String(labelName, Charsets.UTF_8));
        TextView textView4 = this.mGuildDesc;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.mGuildDesc;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
        } else {
            textView2 = textView5;
        }
        textView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.h
            @Override // java.lang.Runnable
            public final void run() {
                RecommendBottomSection.z(RecommendBottomSection.this);
            }
        });
    }
}
