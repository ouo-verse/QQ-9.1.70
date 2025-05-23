package com.tencent.mobileqq.gamecenter.qa.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.util.d;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gp3.e;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0003\u0016\u0019\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011J$\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "cardData", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/gamecenter/qa/util/d$a;", "callback", "o", "Landroid/graphics/Bitmap;", "cardBitmap", "j", "Landroid/view/View;", "view", "l", "Lcom/tencent/mobileqq/gamecenter/qa/util/d$c;", "r", "", "userInputTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Ljava/lang/String;", "mLinkUrl", "b", "Lcom/tencent/mobileqq/gamecenter/qa/util/d$c;", "mCallback", "Lfe1/c;", "c", "Lfe1/c;", "mGameStrategyHandler", "<init>", "(Ljava/lang/String;)V", "d", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mLinkUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fe1.c mGameStrategyHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/d$a;", "", "Landroid/graphics/Bitmap;", "cardBitmap", "", "a", "onLoadFailed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void a(@NotNull Bitmap cardBitmap);

        void onLoadFailed();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/d$c;", "", "", "onLoading", "Landroid/graphics/Bitmap;", "cardBitmap", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "data", "a", "onLoadFailed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface c {
        void a(@Nullable Bitmap cardBitmap, @NotNull GameQALinkCardData data);

        void onLoadFailed();

        void onLoading();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/util/d$d", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "i", "onLoadProgressed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.util.d$d, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7649d implements URLDrawableDownListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f212693e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f212694f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ImageView f212695h;

        C7649d(RelativeLayout relativeLayout, a aVar, ImageView imageView) {
            this.f212693e = relativeLayout;
            this.f212694f = aVar;
            this.f212695h = imageView;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(@NotNull View view, @NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(@NotNull View view, @NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f212695h.setVisibility(0);
            QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, thumbImg onLoadFailed");
            Bitmap l3 = d.this.l(this.f212693e);
            if (l3 != null) {
                this.f212694f.a(l3);
            } else {
                this.f212694f.onLoadFailed();
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(@NotNull View view, @NotNull URLDrawable urlDrawable, @NotNull InterruptedException e16) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(@NotNull View view, @NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(@NotNull View view, @NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, thumbImg onLoadSuccessed");
            Bitmap l3 = d.this.l(this.f212693e);
            if (l3 != null) {
                this.f212694f.a(l3);
            } else {
                this.f212694f.onLoadFailed();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/util/d$e", "Lfe1/a;", "", "errorCode", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "data", "sequenceId", "", "onGetRefMaterialByLink", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e extends fe1.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f212697e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f212698f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Activity f212699h;

        e(long j3, String str, Activity activity) {
            this.f212697e = j3;
            this.f212698f = str;
            this.f212699h = activity;
        }

        @Override // fe1.a, fe1.d
        public void onGetRefMaterialByLink(long errorCode, @Nullable GameQALinkCardData data, long sequenceId) {
            QLog.d("GameQALinkCardProducer", 1, "onGetRefMaterialByLink, errorCode=", Long.valueOf(errorCode));
            if (errorCode != 0 || data == null) {
                c cVar = d.this.mCallback;
                if (cVar != null) {
                    cVar.onLoadFailed();
                }
            } else {
                QLog.d("GameQALinkCardProducer", 1, "onGetRefMaterialByLink, type=", data.getLinkType());
                if (!Intrinsics.areEqual(data.getUrl(), d.this.mLinkUrl) && this.f212697e != sequenceId) {
                    QLog.d("GameQALinkCardProducer", 1, "onGetRefMaterialByLink, url not match");
                    return;
                }
                String str = this.f212698f;
                if (str != null) {
                    data.setTitle(str);
                }
                d.this.n(this.f212699h, data);
            }
            fe1.c cVar2 = d.this.mGameStrategyHandler;
            if (cVar2 != null) {
                cVar2.N0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/util/d$f", "Lcom/tencent/mobileqq/gamecenter/qa/util/d$a;", "Landroid/graphics/Bitmap;", "cardBitmap", "", "a", "onLoadFailed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GameQALinkCardData f212701b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f212702c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/util/d$f$a", "Lcom/tencent/mobileqq/gamecenter/qa/util/d$a;", "Landroid/graphics/Bitmap;", "cardBitmap", "", "a", "onLoadFailed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class a implements a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f212703a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ GameQALinkCardData f212704b;

            a(d dVar, GameQALinkCardData gameQALinkCardData) {
                this.f212703a = dVar;
                this.f212704b = gameQALinkCardData;
            }

            @Override // com.tencent.mobileqq.gamecenter.qa.util.d.a
            public void a(@NotNull Bitmap cardBitmap) {
                Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
                QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, bitmap load success");
                c cVar = this.f212703a.mCallback;
                if (cVar != null) {
                    cVar.a(cardBitmap, this.f212704b);
                }
            }

            @Override // com.tencent.mobileqq.gamecenter.qa.util.d.a
            public void onLoadFailed() {
                QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, bitmap load failed");
                c cVar = this.f212703a.mCallback;
                if (cVar != null) {
                    cVar.onLoadFailed();
                }
            }
        }

        f(GameQALinkCardData gameQALinkCardData, Activity activity) {
            this.f212701b = gameQALinkCardData;
            this.f212702c = activity;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.d.a
        public void a(@NotNull Bitmap cardBitmap) {
            Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
            d dVar = d.this;
            GameQALinkCardData gameQALinkCardData = this.f212701b;
            dVar.j(gameQALinkCardData, cardBitmap, this.f212702c, new a(dVar, gameQALinkCardData));
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.d.a
        public void onLoadFailed() {
            QLog.d("GameQALinkCardProducer", 1, "createLinkCardInternal, bitmap load failed");
            c cVar = d.this.mCallback;
            if (cVar != null) {
                cVar.onLoadFailed();
            }
        }
    }

    public d(@NotNull String mLinkUrl) {
        Intrinsics.checkNotNullParameter(mLinkUrl, "mLinkUrl");
        this.mLinkUrl = mLinkUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(GameQALinkCardData cardData, Bitmap cardBitmap, Activity activity, final a callback) {
        Integer num;
        boolean z16;
        Integer num2;
        Integer num3;
        String str;
        Integer num4;
        if (activity == null) {
            c cVar = this.mCallback;
            if (cVar != null) {
                cVar.onLoadFailed();
                return;
            }
            return;
        }
        View findViewById = activity.getWindow().getDecorView().findViewById(R.id.vjr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.window.decorVie\u2026d(R.id.game_qa_root_view)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        boolean z17 = false;
        View inflate = LayoutInflater.from(BaseApplication.context).inflate(R.layout.ebz, viewGroup, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        final RelativeLayout relativeLayout = (RelativeLayout) inflate;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = viewGroup.getWidth() - x.a(32.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.u7a);
        ViewGroup.LayoutParams layoutParams3 = relativeLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = layoutParams2.width - x.a(24.0f);
        relativeLayout2.setLayoutParams(layoutParams4);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.f113356qe);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.eay);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.xjr);
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.f113206q0);
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.f113196pz);
        if (cardBitmap != null) {
            imageView.setImageBitmap(cardBitmap);
        } else {
            imageView.setImageResource(R.drawable.f160830com);
        }
        textView3.setText(cardData.getUserInfo().name);
        LinkType linkType = cardData.getLinkType();
        LinkType linkType2 = LinkType.REFERENCE_TYPE_CHANNEL;
        if (linkType != linkType2 && cardData.getLinkType() != LinkType.REFERENCE_TYPE_QA) {
            if (cardData.getLinkType() == LinkType.REFERENCE_TYPE_XWORLD) {
                textView4.setText("\u7684\u89c6\u9891");
                textView.setVisibility(8);
                textView2.setText(cardData.getTitle());
                textView2.setTextColor(activity.getResources().getColor(R.color.gamecenter_qa_test_b_txt));
            }
        } else {
            if (!TextUtils.isEmpty(cardData.getTitle())) {
                textView.setVisibility(0);
                textView.setText(cardData.getTitle());
            } else {
                textView.setVisibility(8);
            }
            textView2.setText(GameQAUtil.k(cardData.getContent()));
            textView2.setTextColor(activity.getResources().getColor(R.color.cfz));
            if (cardData.getLinkType() == linkType2) {
                textView4.setText("\u7684\u5e16\u5b50");
            } else {
                textView4.setText("\u7684\u95ee\u7b54");
            }
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.u7f);
        List<GameStrategyPic> pics = cardData.getPics();
        Integer num5 = null;
        if (pics != null) {
            num = Integer.valueOf(pics.size());
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        boolean z18 = true;
        if (num.intValue() <= 0) {
            List<GameStrategyVideo> videos = cardData.getVideos();
            if (videos != null) {
                num4 = Integer.valueOf(videos.size());
            } else {
                num4 = null;
            }
            Intrinsics.checkNotNull(num4);
            if (num4.intValue() <= 0) {
                z16 = false;
                if (!z16) {
                    relativeLayout3.setVisibility(0);
                } else {
                    relativeLayout3.setVisibility(8);
                }
                TextView textView5 = (TextView) relativeLayout.findViewById(R.id.f113386qh);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s\u8d5e", Arrays.copyOf(new Object[]{Integer.valueOf(cardData.getLikeCount())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView5.setText(format);
                ((TextView) relativeLayout.findViewById(R.id.f113236q3)).setText(GameQAUtil.e(cardData.getCreateTs() * 1000));
                C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) relativeLayout.findViewById(R.id.e16);
                TextView textView6 = (TextView) relativeLayout.findViewById(R.id.xec);
                ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.f97005j8);
                ImageView imageView3 = (ImageView) relativeLayout.findViewById(R.id.f97055jc);
                if (z16) {
                    List<GameStrategyVideo> videos2 = cardData.getVideos();
                    if (videos2 != null) {
                        num2 = Integer.valueOf(videos2.size());
                    } else {
                        num2 = null;
                    }
                    Intrinsics.checkNotNull(num2);
                    if (num2.intValue() > 0) {
                        textView6.setVisibility(8);
                        imageView3.setVisibility(0);
                        str = cardData.getVideos().get(0).mCoverUrl;
                    } else {
                        List<GameStrategyPic> pics2 = cardData.getPics();
                        if (pics2 != null) {
                            num3 = Integer.valueOf(pics2.size());
                        } else {
                            num3 = null;
                        }
                        Intrinsics.checkNotNull(num3);
                        if (num3.intValue() > 0) {
                            List<GameStrategyPic> pics3 = cardData.getPics();
                            if (pics3 != null) {
                                num5 = Integer.valueOf(pics3.size());
                            }
                            Intrinsics.checkNotNull(num5);
                            if (num5.intValue() > 1) {
                                textView6.setVisibility(0);
                            } else {
                                textView6.setVisibility(8);
                            }
                            imageView3.setVisibility(8);
                            str = cardData.getPics().get(0).mUrl;
                        } else {
                            str = "";
                        }
                    }
                    imageView2.setVisibility(8);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = new ColorDrawable(0);
                    obtain.mFailedDrawable = new ColorDrawable(0);
                    c11728RoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(4.0f));
                    c11728RoundRectUrlImageView.setURLDrawableDownListener(new C7649d(relativeLayout, callback, imageView2));
                    URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                    Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
                    c11728RoundRectUrlImageView.setImageDrawable(drawable);
                    drawable.startDownload(true);
                    if (drawable.getStatus() == 1) {
                        QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, thumbImg exist");
                        z17 = true;
                    }
                    z18 = z17;
                }
                if (z18) {
                    viewGroup.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.util.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.k(d.this, relativeLayout, callback);
                        }
                    }, 200L);
                }
                relativeLayout.requestLayout();
            }
        }
        z16 = true;
        if (!z16) {
        }
        TextView textView52 = (TextView) relativeLayout.findViewById(R.id.f113386qh);
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%s\u8d5e", Arrays.copyOf(new Object[]{Integer.valueOf(cardData.getLikeCount())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView52.setText(format2);
        ((TextView) relativeLayout.findViewById(R.id.f113236q3)).setText(GameQAUtil.e(cardData.getCreateTs() * 1000));
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView2 = (C11728RoundRectUrlImageView) relativeLayout.findViewById(R.id.e16);
        TextView textView62 = (TextView) relativeLayout.findViewById(R.id.xec);
        ImageView imageView22 = (ImageView) relativeLayout.findViewById(R.id.f97005j8);
        ImageView imageView32 = (ImageView) relativeLayout.findViewById(R.id.f97055jc);
        if (z16) {
        }
        if (z18) {
        }
        relativeLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, RelativeLayout cardView, a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardView, "$cardView");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("GameQALinkCardProducer", 1, "createCardBitmap, create");
        Bitmap l3 = this$0.l(cardView);
        if (l3 != null) {
            callback.a(l3);
        } else {
            callback.onLoadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap l(View view) {
        if (view == null) {
            return null;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            view.measure(0, 0);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        QLog.d("GameQALinkCardProducer", 1, "createCardViewBitmap, width:" + view.getMeasuredWidth() + ", height:" + view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Activity activity, GameQALinkCardData cardData) {
        if (GameQAUtil.t(cardData)) {
            o(cardData, new f(cardData, activity));
            return;
        }
        QLog.d("GameQALinkCardProducer", 1, "createLinkCardInternal, type not support=", cardData.getLinkType());
        c cVar = this.mCallback;
        if (cVar != null) {
            cVar.onLoadFailed();
        }
    }

    private final void o(GameQALinkCardData cardData, final a callback) {
        if (callback == null) {
            return;
        }
        if (TextUtils.isEmpty(cardData.getUserInfo().avatar)) {
            callback.onLoadFailed();
            return;
        }
        Bitmap b16 = gp3.e.a().b(cardData.getUserInfo().avatar);
        if (b16 != null) {
            callback.a(b16);
        } else {
            gp3.e.a().c(cardData.getUserInfo().avatar, new e.b() { // from class: com.tencent.mobileqq.gamecenter.qa.util.a
                @Override // gp3.e.b
                public final void onImageLoaded(String str, Bitmap bitmap, String str2) {
                    d.p(d.a.this, str, bitmap, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final a callback, String str, final Bitmap bitmap, String str2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.util.b
            @Override // java.lang.Runnable
            public final void run() {
                d.q(bitmap, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Bitmap bitmap, a callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (bitmap != null) {
            callback.a(bitmap);
        }
    }

    public final void m(@Nullable Activity activity, @Nullable GameQALinkCardData cardData, @Nullable String userInputTitle) {
        c cVar = this.mCallback;
        if (cVar != null) {
            cVar.onLoading();
        }
        if (cardData != null) {
            if (userInputTitle != null) {
                cardData.setTitle(userInputTitle);
            }
            n(activity, cardData);
            return;
        }
        fe1.c cVar2 = this.mGameStrategyHandler;
        if (cVar2 != null) {
            cVar2.N0();
        }
        this.mGameStrategyHandler = new fe1.c();
        long currentTimeMillis = System.currentTimeMillis();
        fe1.c cVar3 = this.mGameStrategyHandler;
        if (cVar3 != null) {
            cVar3.Z0(new e(currentTimeMillis, userInputTitle, activity));
        }
        fe1.c cVar4 = this.mGameStrategyHandler;
        if (cVar4 != null) {
            cVar4.a0(this.mLinkUrl, currentTimeMillis);
        }
    }

    public final void r(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }
}
