package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.config.GuildFeedPreferConfigParser;
import com.tencent.mobileqq.guild.feed.feedsquare.section.h;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import h53.AsciiHalfCharacterCounter;
import h53.CharacterCountInfo;
import h53.QUIInputCountCalculateStrategy;
import h53.SpanPair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0002HIB\u0019\u0012\u0006\u00101\u001a\u00020.\u0012\b\b\u0002\u00103\u001a\u00020\u000e\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0002J!\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u000e2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J,\u0010$\u001a\u00020\u00062\n\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010 \u001a\u00020\n2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J2\u0010)\u001a\u00020\u000e2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0&2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0015j\b\u0012\u0004\u0012\u00020\b`\u0017J(\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0&2\u0006\u0010+\u001a\u00020*2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00102R\u0016\u00105\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u00104R\u0016\u00107\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u00106R\u0016\u00108\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u00106R\u0016\u00109\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u00104R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R&\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", DomainData.DOMAIN_NAME, "", "text", "", "charLimit", "p", "newStFeed", "", tl.h.F, "Ljava/io/Serializable;", "T", "obj", "f", "(Ljava/io/Serializable;)Ljava/io/Serializable;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", "Lkotlin/collections/ArrayList;", "currentExternalLikeUserList", "j", "", "g", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "position", "", "", "payload", "k", "l", "Lkotlin/Pair;", "calculate", "stringList", "i", "Landroid/widget/TextView;", "textView", "", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "depends", "Z", "isNeedBackground", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "preferName", "preferTipText", "preferGapView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "content", "D", "Ljava/util/ArrayList;", "lastExternalLikeUserList", "Lh53/e;", "E", "Lh53/e;", "calculateStrategy", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;Z)V", UserInfo.SEX_FEMALE, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends a<qj1.h> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final MutableLiveData<GuildFeedPreferConfigParser.Data> G = GuildFeedPreferConfigParser.INSTANCE.a();

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout content;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GProStUser> lastExternalLikeUserList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private QUIInputCountCalculateStrategy calculateStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isNeedBackground;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView preferName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView preferTipText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View preferGapView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000f\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$a;", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Data;", DownloadInfo.spKey_Config, "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "", "b", "()I", "maxLength", "", "c", "()Z", "preferSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.section.h$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MutableLiveData<GuildFeedPreferConfigParser.Data> a() {
            return h.G;
        }

        public final int b() {
            GuildFeedPreferConfigParser.Data value = a().getValue();
            if (value != null) {
                return value.getNickMaxLength();
            }
            return 6;
        }

        public final boolean c() {
            GuildFeedPreferConfigParser.Data value = a().getValue();
            if (value != null) {
                return value.getPreferSwitch();
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull View rootView, @NotNull GProStFeed stFeed);

        void b(@NotNull View rootView, @NotNull GProStFeed stFeed);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/h$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<ArrayList<String>> f219230e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<SpannableStringBuilder> f219231f;

        c(Ref.ObjectRef<ArrayList<String>> objectRef, Ref.ObjectRef<SpannableStringBuilder> objectRef2) {
            this.f219230e = objectRef;
            this.f219231f = objectRef2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(h this$0, Ref.ObjectRef stringList, Ref.ObjectRef frontString) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(stringList, "$stringList");
            Intrinsics.checkNotNullParameter(frontString, "$frontString");
            TextView textView = this$0.preferName;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferName");
                textView = null;
            }
            if (this$0.i(this$0.e(textView, (List) stringList.element), (ArrayList) stringList.element)) {
                TextView textView3 = this$0.preferName;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferName");
                    textView3 = null;
                }
                textView3.setText((CharSequence) ((ArrayList) stringList.element).get(0));
            } else {
                TextView textView4 = this$0.preferName;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferName");
                    textView4 = null;
                }
                textView4.setText((CharSequence) frontString.element);
            }
            TextView textView5 = this$0.preferName;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferName");
            } else {
                textView2 = textView5;
            }
            textView2.requestLayout();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3;
            boolean z16;
            TextView textView = h.this.preferName;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferName");
                textView = null;
            }
            textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            TextView textView3 = h.this.preferName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferName");
                textView3 = null;
            }
            Layout layout = textView3.getLayout();
            if (layout != null) {
                TextView textView4 = h.this.preferName;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferName");
                    textView4 = null;
                }
                i3 = layout.getEllipsisCount(textView4.getLineCount() - 1);
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("GuildFeedPreferComponents", 1, "isEllipsis " + z16);
            if (this.f219230e.element.size() > 1 && z16) {
                h hVar = h.this;
                TextView textView5 = hVar.preferName;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferName");
                    textView5 = null;
                }
                Pair<Integer, Integer> e16 = hVar.e(textView5, this.f219230e.element);
                QLog.i("GuildFeedPreferComponents", 1, "lastIndex " + e16.getFirst() + ", lastCount " + e16.getSecond());
                if (h.this.i(e16, this.f219230e.element)) {
                    TextView textView6 = h.this.preferTipText;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferTipText");
                        textView6 = null;
                    }
                    textView6.setText("\u7b49\u4eba\u8d5e\u4e86");
                    TextView textView7 = h.this.preferName;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferName");
                        textView7 = null;
                    }
                    textView7.setText(this.f219230e.element.get(0));
                    TextView textView8 = h.this.preferName;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferName");
                        textView8 = null;
                    }
                    textView8.requestLayout();
                }
                if (e16.getFirst().intValue() == 2 && this.f219230e.element.size() == 3 && this.f219230e.element.get(2).length() > 2 && e16.getSecond().intValue() < 3) {
                    TextView textView9 = h.this.preferTipText;
                    if (textView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferTipText");
                        textView9 = null;
                    }
                    textView9.setText("\u7b49\u4eba\u8d5e\u4e86");
                    TextView textView10 = h.this.preferTipText;
                    if (textView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferTipText");
                    } else {
                        textView2 = textView10;
                    }
                    final h hVar2 = h.this;
                    final Ref.ObjectRef<ArrayList<String>> objectRef = this.f219230e;
                    final Ref.ObjectRef<SpannableStringBuilder> objectRef2 = this.f219231f;
                    textView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.c.b(h.this, objectRef, objectRef2);
                        }
                    });
                }
            }
        }
    }

    public /* synthetic */ h(b bVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i3 & 2) != 0 ? true : z16);
    }

    private final <T extends Serializable> T f(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Object readObject = objectInputStream.readObject();
        Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPreferComponents.deepCopy");
        T t16 = (T) readObject;
        objectInputStream.close();
        return t16;
    }

    private final boolean h(GProStFeed newStFeed) {
        boolean z16;
        boolean z17;
        boolean z18;
        View view = this.preferGapView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferGapView");
            view = null;
        }
        ArrayList<GProStComment> arrayList = newStFeed.externalCommentList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        view.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view)) == null) {
            view.setVisibility(0);
        }
        if (this.isNeedBackground) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            View view3 = this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view3 = null;
            }
            gradientDrawable.setColor(view3.getContext().getColorStateList(R.color.qui_common_fill_standard_extra));
            float dip2px = ViewUtils.dip2px(8.0f);
            int dip2px2 = ViewUtils.dip2px(6.0f);
            float[] fArr = {dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f};
            ArrayList<GProStComment> arrayList2 = newStFeed.externalCommentList;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                fArr = new float[]{dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px};
                dip2px2 = ViewUtils.dip2px(9.0f);
            }
            LinearLayout linearLayout = this.content;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("content");
                linearLayout = null;
            }
            ViewExtKt.c(linearLayout, dip2px2);
            gradientDrawable.setCornerRadii(fArr);
            View view4 = this.rootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view4 = null;
            }
            view4.setBackground(gradientDrawable);
        }
        QLog.i("GuildFeedPreferComponents", 1, "initPreferContainer feedId:" + newStFeed.idd + " preferCountWithoutLike " + newStFeed.totalPrefer.preferCountWithoutLike + " , size " + newStFeed.externalLikeUserList.size());
        ArrayList<GProStUser> arrayList3 = newStFeed.externalLikeUserList;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && INSTANCE.c()) {
            View view5 = this.rootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view2 = view5;
            }
            view2.setVisibility(0);
            return true;
        }
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view6;
        }
        view2.setVisibility(8);
        return false;
    }

    private final boolean j(ArrayList<GProStUser> currentExternalLikeUserList) {
        if (this.lastExternalLikeUserList.isEmpty() || currentExternalLikeUserList.isEmpty() || this.lastExternalLikeUserList.size() != currentExternalLikeUserList.size()) {
            return false;
        }
        int size = currentExternalLikeUserList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.lastExternalLikeUserList.get(i3).idd, currentExternalLikeUserList.get(i3).idd) || !Intrinsics.areEqual(this.lastExternalLikeUserList.get(i3).nick, currentExternalLikeUserList.get(i3).nick)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.text.SpannableStringBuilder, T] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.text.SpannableStringBuilder, T] */
    private final void n(final GProStFeed stFeed) {
        List take;
        View view;
        String str;
        SpannableString spannableString;
        Ref.ObjectRef objectRef;
        int lastIndexOf$default;
        if (!h(stFeed)) {
            return;
        }
        ArrayList<GProStUser> arrayList = stFeed.externalLikeUserList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "stFeed.externalLikeUserList");
        if (j(arrayList)) {
            QLog.i("GuildFeedPreferComponents", 1, "stFeed is equal,feedId:" + stFeed.idd + " ,externalLikeUserList " + stFeed.externalLikeUserList.size());
            return;
        }
        this.lastExternalLikeUserList = new ArrayList<>();
        ArrayList<GProStUser> arrayList2 = stFeed.externalLikeUserList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "stFeed.externalLikeUserList");
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            this.lastExternalLikeUserList.add(f((GProStUser) it.next()));
        }
        QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy = null;
        if (stFeed.externalLikeUserList.size() > 3) {
            TextView textView = this.preferTipText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferTipText");
                textView = null;
            }
            textView.setText("\u7b49\u4eba\u8d5e\u4e86");
        } else {
            TextView textView2 = this.preferTipText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferTipText");
                textView2 = null;
            }
            textView2.setText("\u8d5e\u4e86");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new SpannableStringBuilder("");
        int min = Math.min(stFeed.externalLikeUserList.size() - 1, 2);
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = new ArrayList();
        ArrayList<GProStUser> arrayList3 = stFeed.externalLikeUserList;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "stFeed.externalLikeUserList");
        take = CollectionsKt___CollectionsKt.take(arrayList3, 3);
        int i3 = 0;
        for (Object obj : take) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String name = ((GProStUser) obj).nick;
            int d16 = CharacterCountInfo.d(h53.c.a(name, this.calculateStrategy), qUIInputCountCalculateStrategy, 1, qUIInputCountCalculateStrategy);
            Companion companion = INSTANCE;
            if (d16 > companion.b()) {
                Intrinsics.checkNotNullExpressionValue(name, "name");
                name = p(name, companion.b(), stFeed);
            }
            if (i3 == min) {
                str = "";
            } else {
                str = ",";
            }
            SpannableString spannableString2 = new SpannableString(name + str);
            if (i3 == min && i3 == 2) {
                ?? spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder.toString());
                objectRef2.element = spannableStringBuilder2;
                CharSequence charSequence = (CharSequence) spannableStringBuilder2;
                spannableString = spannableString2;
                objectRef = objectRef3;
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(charSequence, ",", 0, false, 6, (Object) null);
                if (lastIndexOf$default != -1) {
                    ((SpannableStringBuilder) objectRef2.element).delete(lastIndexOf$default, lastIndexOf$default + 1);
                }
            } else {
                spannableString = spannableString2;
                objectRef = objectRef3;
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            ((ArrayList) objectRef.element).add(spannableString.toString());
            objectRef3 = objectRef;
            i3 = i16;
            qUIInputCountCalculateStrategy = null;
        }
        Ref.ObjectRef objectRef4 = objectRef3;
        TextView textView3 = this.preferName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferName");
            textView3 = null;
        }
        textView3.setText(spannableStringBuilder);
        TextView textView4 = this.preferName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferName");
            textView4 = null;
        }
        com.tencent.mobileqq.guild.base.extension.s.a(textView4, 500, 1);
        TextView textView5 = this.preferName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferName");
            textView5 = null;
        }
        textView5.requestLayout();
        TextView textView6 = this.preferName;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferName");
            textView6 = null;
        }
        textView6.getViewTreeObserver().addOnGlobalLayoutListener(new c(objectRef4, objectRef2));
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                h.o(h.this, stFeed, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h this$0, GProStFeed stFeed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            b bVar = this$0.depends;
            View view2 = this$0.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            bVar.a(view2, stFeed);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String p(String text, int charLimit, GProStFeed stFeed) {
        CharSequence trim;
        boolean z16;
        int length;
        int g16;
        boolean z17 = true;
        if (stFeed.externalLikeUserList.size() == 1) {
            return text;
        }
        SparseArray<SpanPair> c16 = h53.c.f404346a.c(new QQText(text, 3), text);
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, this.calculateStrategy, 31, null);
        float f16 = charLimit;
        float i3 = f16 - asciiHalfCharacterCounter.i();
        int i16 = 0;
        while (i16 < text.length() && !asciiHalfCharacterCounter.getIsLimit() && i3 > 0.0f) {
            int indexOfKey = c16.indexOfKey(i16);
            if (indexOfKey >= 0) {
                SpanPair valueAt = c16.valueAt(indexOfKey);
                Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                g16 = asciiHalfCharacterCounter.f(valueAt, i3);
            } else {
                int i17 = (-indexOfKey) - 1;
                if (i17 < c16.size()) {
                    length = c16.valueAt(i17).getStart();
                } else {
                    length = text.length();
                }
                g16 = asciiHalfCharacterCounter.g(text, i16, length, i3);
            }
            float i18 = f16 - asciiHalfCharacterCounter.i();
            if (i18 >= 0.0f) {
                i16 += g16;
            }
            i3 = i18;
        }
        QLog.i("GuildFeedPreferComponents", 1, "guild nick " + text + " remove Start " + i16);
        String substring = text.substring(0, i16);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        trim = StringsKt__StringsKt.trim((CharSequence) substring);
        String obj = trim.toString();
        int i19 = 0;
        while (true) {
            if (i19 >= obj.length()) {
                break;
            }
            if (obj.charAt(i19) == '\u007f') {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
                break;
            }
            i19++;
        }
        if (z17) {
            obj = "";
        }
        return obj + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    @NotNull
    public final Pair<Integer, Integer> e(@NotNull TextView textView, @NotNull List<String> stringList) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(stringList, "stringList");
        TextPaint paint = textView.getPaint();
        int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        Iterator<String> it = stringList.iterator();
        int i3 = 0;
        float f16 = 0.0f;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (it.hasNext()) {
                int i19 = i17 + 1;
                String next = it.next();
                float measureText = paint.measureText(next) + f16;
                float f17 = width;
                if (measureText > f17) {
                    float measureText2 = (f17 - f16) - paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    if (measureText2 > 0.0f) {
                        i3 = paint.breakText(next, true, measureText2, null);
                    }
                    i18 = i3;
                } else {
                    i18 = next.length();
                    f16 = measureText;
                    i16 = i17;
                    i17 = i19;
                }
            } else {
                i17 = i16;
                break;
            }
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @NotNull
    public int[] g() {
        return new int[]{R.id.w_8};
    }

    public final boolean i(@NotNull Pair<Integer, Integer> calculate, @NotNull ArrayList<String> stringList) {
        Intrinsics.checkNotNullParameter(calculate, "calculate");
        Intrinsics.checkNotNullParameter(stringList, "stringList");
        if (calculate.getFirst().intValue() == 1 && stringList.get(1).length() > 2 && calculate.getSecond().intValue() < 3) {
            return true;
        }
        return false;
    }

    public void k(@NotNull qj1.h data, int position, @Nullable List<Object> payload) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(data, "data");
        Object a16 = data.a();
        View view = null;
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed != null) {
            n(gProStFeed);
            b bVar = this.depends;
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view = view2;
            }
            bVar.b(view, gProStFeed);
        }
        Companion companion = INSTANCE;
        QLog.i("GuildFeedPreferComponents", 1, "maxLength " + companion.b() + ",preferSwitch " + companion.c());
    }

    public final void l(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        n(stFeed);
    }

    public void m(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wcs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.guild_feed_prefer)");
        this.rootView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.content)");
        this.content = (LinearLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f26800ei);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.prefer_name)");
        this.preferName = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f26820ek);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.prefer_tip_text)");
        this.preferTipText = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f26780eg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.prefer_gap_view)");
        this.preferGapView = findViewById5;
    }

    public h(@NotNull b depends, boolean z16) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        this.isNeedBackground = z16;
        this.lastExternalLikeUserList = new ArrayList<>();
        this.calculateStrategy = new QUIInputCountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
    }
}
