package com.tencent.qqnt.aio.menu.emoreply.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000501234B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\n\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "data", "", "t0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "vh", "position", "", "onBindViewHolder", "getItemViewType", "", "list", "u0", "", "scale", "w0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "columnNum", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "emoReplyList", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;", "D", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;", "getOnEmoClickListener", "()Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;", "v0", "(Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;)V", "onEmoClickListener", "E", UserInfo.SEX_FEMALE, "<init>", "(I)V", "a", "EmoView", "b", "c", "d", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int G;
    private static final int H;
    private static final int I;
    private static final int J;
    private static final int K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int P;
    private static final int Q;
    private static final int R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<EmotionPanelData> emoReplyList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private c onEmoClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private float scale;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int columnNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$EmoView;", "Landroid/widget/FrameLayout;", "", "scale", "Landroid/widget/FrameLayout$LayoutParams;", "b", "Lcom/tencent/mobileqq/emoticonview/EmoticonImageView;", "d", "Lcom/tencent/mobileqq/emoticonview/EmoticonImageView;", "a", "()Lcom/tencent/mobileqq/emoticonview/EmoticonImageView;", "imageView", "value", "e", UserInfo.SEX_FEMALE, "getScale", "()F", "setScale", "(F)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class EmoView extends FrameLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EmoticonImageView imageView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float scale;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmoView(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            EmoticonImageView emoticonImageView = new EmoticonImageView(context);
            emoticonImageView.setLayoutParams(b(this.scale));
            addView(emoticonImageView);
            this.imageView = emoticonImageView;
            this.scale = 1.0f;
            Companion companion = AIOEmoReplyMoreAdapter.INSTANCE;
            setLayoutParams(new LinearLayout.LayoutParams((int) (companion.d() * this.scale), (int) (companion.c() * this.scale)));
        }

        private final FrameLayout.LayoutParams b(float scale) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (AIOEmoReplyMoreAdapter.P * scale), (int) (AIOEmoReplyMoreAdapter.P * scale));
            layoutParams.gravity = 17;
            return layoutParams;
        }

        @NotNull
        public final EmoticonImageView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EmoticonImageView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imageView;
        }

        public final void setScale(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
                return;
            }
            this.scale = f16;
            this.imageView.setLayoutParams(b(f16));
            Companion companion = AIOEmoReplyMoreAdapter.INSTANCE;
            setLayoutParams(new LinearLayout.LayoutParams((int) (companion.d() * f16), (int) (companion.c() * f16)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$a;", "", "", "FIRST_LINE_TITLE_MARGIN_TOP", "I", "e", "()I", "TITLE_HEIGHT", "f", "EMO_LINE_MARGIN_START", "b", "EMO_LINE_MARGIN_END", "a", "EMO_PARENT_WIDTH", "d", "EMO_PARENT_HEIGHT", "c", "EMO_MARGIN_BOTTOM_WITH_LAST", "EMO_MARGIN_TOP_WITH_UNDER_LINE", "EMO_SIZE", "EMO_TYPE", "OTHER_LINE_TITLE_MARGIN_TOP", "TITLE_MARGIN_START", "TITLE_TYPE", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMoreAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return AIOEmoReplyMoreAdapter.M;
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return AIOEmoReplyMoreAdapter.L;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return AIOEmoReplyMoreAdapter.R;
            }
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return AIOEmoReplyMoreAdapter.Q;
            }
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOEmoReplyMoreAdapter.G;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return AIOEmoReplyMoreAdapter.I;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u0011\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "emoticonInfo", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "emoReplyLineList", "", "isPreLineTitle", "isLastLine", "Landroid/view/View$OnClickListener;", "onClickListener", "", "scale", "", "l", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "contentView", "", UserInfo.SEX_FEMALE, "I", "columnNum", "", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$EmoView;", "G", "[Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$EmoView;", "contentViews", "<init>", "(Landroid/widget/LinearLayout;I)V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout contentView;

        /* renamed from: F, reason: from kotlin metadata */
        private final int columnNum;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final EmoView[] contentViews;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull LinearLayout contentView, int i3) {
            super(contentView);
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) contentView, i3);
                return;
            }
            this.contentView = contentView;
            this.columnNum = i3;
            EmoView[] emoViewArr = new EmoView[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                EmoView emoView = new EmoView(context);
                this.contentView.addView(emoView);
                Unit unit = Unit.INSTANCE;
                emoViewArr[i16] = emoView;
            }
            this.contentViews = emoViewArr;
        }

        private final Drawable m(SystemAndEmojiEmoticonInfo emoticonInfo) {
            return emoticonInfo.getDrawable(false);
        }

        public final void l(@NotNull List<? extends EmotionPanelData> emoReplyLineList, boolean isPreLineTitle, boolean isLastLine, @NotNull View.OnClickListener onClickListener, float scale) {
            RecyclerView.LayoutParams layoutParams;
            RecyclerView.LayoutParams layoutParams2;
            int i3;
            int i16;
            char c16;
            boolean startsWith$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            char c17 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, emoReplyLineList, Boolean.valueOf(isPreLineTitle), Boolean.valueOf(isLastLine), onClickListener, Float.valueOf(scale));
                return;
            }
            Intrinsics.checkNotNullParameter(emoReplyLineList, "emoReplyLineList");
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            int min = Math.min(emoReplyLineList.size(), this.columnNum);
            Iterator<T> it = emoReplyLineList.subList(0, min).iterator();
            int i17 = 0;
            while (true) {
                layoutParams = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                EmotionPanelData emotionPanelData = (EmotionPanelData) next;
                EmoView emoView = this.contentViews[i17];
                emoView.setScale(scale);
                EmoticonImageView a16 = emoView.a();
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    a16.setTag(emotionPanelData);
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (systemAndEmojiEmoticonInfo.code == -1) {
                        emoView.setVisibility(8);
                    } else {
                        emoView.setVisibility(0);
                        if (emotionPanelData != a16.getTag(R.id.kxb)) {
                            a16.setTag(R.id.kxb, emotionPanelData);
                            if (((IApolloDependApi) QRoute.api(IApolloDependApi.class)).shouldShowNewIcon(systemAndEmojiEmoticonInfo.code)) {
                                a16.setNewIconVisible(true);
                                ((IApolloDependApi) QRoute.api(IApolloDependApi.class)).onEmoticonNewIconShown(systemAndEmojiEmoticonInfo.code);
                            } else {
                                a16.setNewIconVisible(false);
                            }
                            a16.setImageDrawable(m(systemAndEmojiEmoticonInfo));
                            a16.setOnClickListener(onClickListener);
                            int i19 = systemAndEmojiEmoticonInfo.emotionType;
                            if (i19 == 1) {
                                String faceDescription = QQSysFaceUtil.getFaceDescription(systemAndEmojiEmoticonInfo.code);
                                if (faceDescription != null) {
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(faceDescription, "/", false, 2, null);
                                    if (startsWith$default && faceDescription.length() > 1) {
                                        faceDescription = faceDescription.substring(1);
                                        Intrinsics.checkNotNullExpressionValue(faceDescription, "this as java.lang.String).substring(startIndex)");
                                    }
                                }
                                if (faceDescription != null) {
                                    a16.setContentDescription(faceDescription);
                                }
                            } else {
                                c16 = 2;
                                if (i19 == 2) {
                                    a16.setContentDescription(QQEmojiUtil.getEmojiDescription(systemAndEmojiEmoticonInfo.code));
                                } else {
                                    a16.setContentDescription(HardCodeUtil.qqStr(R.string.f230296yr));
                                }
                            }
                        }
                    }
                    c16 = 2;
                } else {
                    c16 = c17;
                    emoView.setVisibility(8);
                }
                c17 = c16;
                i17 = i18;
            }
            int i26 = this.columnNum;
            if (i26 - min > 0) {
                while (min < i26) {
                    this.contentViews[min].setVisibility(8);
                    min++;
                }
            }
            LinearLayout linearLayout = this.contentView;
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            if (layoutParams3 instanceof RecyclerView.LayoutParams) {
                layoutParams2 = (RecyclerView.LayoutParams) layoutParams3;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                if (isPreLineTitle) {
                    i3 = (int) (AIOEmoReplyMoreAdapter.K * scale);
                } else {
                    i3 = 0;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i3;
                if (isLastLine) {
                    i16 = (int) (AIOEmoReplyMoreAdapter.N * scale);
                } else {
                    i16 = 0;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i16;
                layoutParams = layoutParams2;
            }
            linearLayout.setLayoutParams(layoutParams);
            LinearLayout linearLayout2 = this.contentView;
            Companion companion = AIOEmoReplyMoreAdapter.INSTANCE;
            linearLayout2.setPadding((int) (companion.b() * scale), 0, (int) (companion.a() * scale), 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;", "", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "emoticonInfo", "", "a", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface c {
        void a(@NotNull SystemAndEmojiEmoticonInfo emoticonInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "data", "", "position", "", "scale", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView titleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            } else {
                this.titleView = (TextView) itemView.findViewById(R.id.title);
            }
        }

        public final void l(@NotNull EmotionPanelData data, int position, float scale) {
            String str;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, data, Integer.valueOf(position), Float.valueOf(scale));
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof SystemAndEmojiEmoticonInfo) {
                str = ((SystemAndEmojiEmoticonInfo) data).title;
            } else {
                str = "";
            }
            this.titleView.setText(str);
            this.titleView.setTextSize(10.0f * scale);
            ViewGroup.LayoutParams layoutParams = this.titleView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart((int) (AIOEmoReplyMoreAdapter.J * scale));
                marginLayoutParams.height = (int) (AIOEmoReplyMoreAdapter.INSTANCE.f() * scale);
            }
            View view = this.itemView;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 != null) {
                if (position != 0) {
                    i3 = AIOEmoReplyMoreAdapter.H;
                } else {
                    i3 = AIOEmoReplyMoreAdapter.INSTANCE.e();
                }
                marginLayoutParams2.topMargin = (int) (i3 * scale);
                marginLayoutParams3 = marginLayoutParams2;
            }
            view.setLayoutParams(marginLayoutParams3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        G = l.b(12);
        H = l.b(10);
        I = l.b(16);
        J = l.b(12);
        K = l.b(2);
        L = l.b(6);
        M = l.b(2);
        N = l.b(10);
        P = l.b(32);
        Q = l.b(44);
        R = l.b(44);
    }

    public AIOEmoReplyMoreAdapter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.columnNum = i3;
        this.emoReplyList = new ArrayList<>();
        this.scale = 1.0f;
    }

    private final boolean t0(EmotionPanelData data) {
        if (!(data instanceof SystemAndEmojiEmoticonInfo) || ((SystemAndEmojiEmoticonInfo) data).emotionType != 3) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (this.columnNum == 0) {
            return 0;
        }
        int size = this.emoReplyList.size();
        int i3 = this.columnNum;
        int i16 = size / i3;
        if (size % i3 > 0) {
            return i16 + 1;
        }
        return i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, position)).intValue();
        }
        super.getItemViewType(position);
        EmotionPanelData emotionPanelData = this.emoReplyList.get(this.columnNum * position);
        Intrinsics.checkNotNullExpressionValue(emotionPanelData, "emoReplyList[lineStartPosition]");
        EmotionPanelData emotionPanelData2 = emotionPanelData;
        if (emotionPanelData2 instanceof SystemAndEmojiEmoticonInfo) {
            if (((SystemAndEmojiEmoticonInfo) emotionPanelData2).emotionType == 3) {
                return 1;
            }
            return 2;
        }
        return super.getItemViewType(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder vh5, int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) vh5, position);
            return;
        }
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (vh5 instanceof d) {
            EmotionPanelData emotionPanelData = this.emoReplyList.get(this.columnNum * position);
            Intrinsics.checkNotNullExpressionValue(emotionPanelData, "emoReplyList[position * columnNum]");
            ((d) vh5).l(emotionPanelData, position, this.scale);
        } else if (vh5 instanceof b) {
            b bVar = (b) vh5;
            ArrayList<EmotionPanelData> arrayList = this.emoReplyList;
            List<EmotionPanelData> subList = arrayList.subList(this.columnNum * position, Math.min(arrayList.size(), (position + 1) * this.columnNum));
            Intrinsics.checkNotNullExpressionValue(subList, "emoReplyList.subList(\n  \u2026umnNum)\n                )");
            EmotionPanelData emotionPanelData2 = this.emoReplyList.get((position - 1) * this.columnNum);
            Intrinsics.checkNotNullExpressionValue(emotionPanelData2, "emoReplyList[(position - 1) * columnNum]");
            boolean t06 = t0(emotionPanelData2);
            if (position == getNUM_BACKGOURND_ICON() - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.l(subList, t06, z16, this, this.scale);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EmoticonImageView emoticonImageView;
        c cVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = null;
            if (v3 instanceof EmoticonImageView) {
                emoticonImageView = (EmoticonImageView) v3;
            } else {
                emoticonImageView = null;
            }
            if (emoticonImageView != null) {
                Object tag = emoticonImageView.getTag(R.id.kxb);
                if (tag instanceof SystemAndEmojiEmoticonInfo) {
                    systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) tag;
                }
                if (systemAndEmojiEmoticonInfo != null && (cVar = this.onEmoClickListener) != null) {
                    cVar.a(systemAndEmojiEmoticonInfo);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dus, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026em_layout, parent, false)");
            return new d(inflate);
        }
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(L, 0, M, 0);
        return new b(linearLayout, this.columnNum);
    }

    public final void u0(@NotNull List<? extends EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        this.emoReplyList.clear();
        this.emoReplyList.addAll(list);
        notifyDataSetChanged();
    }

    public final void v0(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.onEmoClickListener = cVar;
        }
    }

    public final void w0(float scale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(scale));
        } else {
            this.scale = scale;
            notifyDataSetChanged();
        }
    }
}
