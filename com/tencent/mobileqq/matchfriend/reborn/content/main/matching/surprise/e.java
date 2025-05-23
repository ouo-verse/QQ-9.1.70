package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.utils.n;
import com.tencent.mobileqq.qui.dialog.QUICompatDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendItem;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendRsp;
import com.tencent.util.AnimateUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001,B/\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010 \u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/e;", "Lcom/tencent/mobileqq/qui/dialog/QUICompatDialog;", "", "initView", ExifInterface.LATITUDE_SOUTH, "b0", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "imageView", "", "avatar", "d0", "c0", "Y", "Landroid/widget/TextView;", "greetingTextTv", "i0", "U", "T", "", "g0", "f0", "", "clickPos", "e0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;", "rsp", "Lkotlin/Function1;", "D", "Lkotlin/jvm/functions/Function1;", "greetingListener", "E", "I", "greetingTextIndex", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;Lkotlin/jvm/functions/Function1;)V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends QUICompatDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final SurpriseMatchPB$RecommendRsp rsp;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function1<String, Unit> greetingListener;

    /* renamed from: E, reason: from kotlin metadata */
    private int greetingTextIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/e$b", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends AnimateUtils.AnimationAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f244525d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f244526e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlphaAnimation f244527f;

        b(TextView textView, String str, AlphaAnimation alphaAnimation) {
            this.f244525d = textView;
            this.f244526e = str;
            this.f244527f = alphaAnimation;
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f244525d.setText(this.f244526e);
            this.f244525d.startAnimation(this.f244527f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(Context context, SurpriseMatchPB$RecommendRsp rsp, Function1<? super String, Unit> function1) {
        super(context, R.style.qZoneInputDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.rsp = rsp;
        this.greetingListener = function1;
        this.greetingTextIndex = -1;
    }

    private final void R() {
        int collectionSizeOrDefault;
        List listOf;
        List listOf2;
        Object orNull;
        Object orNull2;
        List<SurpriseMatchPB$RecommendItem> list = this.rsp.items.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.items.get()");
        List<SurpriseMatchPB$RecommendItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((SurpriseMatchPB$RecommendItem) it.next()).user_info.avatar.get());
        }
        List g06 = g0(arrayList);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageView[]{(ImageView) findViewById(R.id.oi6), (ImageView) findViewById(R.id.oi7), (ImageView) findViewById(R.id.oi8)});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{findViewById(R.id.oim), findViewById(R.id.oin), findViewById(R.id.oio)});
        int size = listOf.size();
        for (int i3 = 0; i3 < size; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(listOf, i3);
            ImageView imageView = (ImageView) orNull;
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(listOf2, i3);
            View view = (View) orNull2;
            CharSequence charSequence = (CharSequence) g06.get(i3);
            if (charSequence == null || charSequence.length() == 0) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            if (imageView != null) {
                d0(imageView, (String) g06.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
        this$0.e0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
        this$0.e0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(e this$0, TextView greetingTextTv, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e0(1);
        Intrinsics.checkNotNullExpressionValue(greetingTextTv, "greetingTextTv");
        this$0.i0(greetingTextTv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(TextView textView, e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence text = textView.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null || obj.length() == 0) {
            QLog.d("QQStrangerSurpriseMatchingDialog", 1, "greeting text is null");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerSurpriseMatchingDialog", 1, "network not available");
            QQToast.makeText(this$0.getContext(), 1, R.string.x0e, 0).show();
            return;
        }
        Function1<String, Unit> function1 = this$0.greetingListener;
        if (function1 != null) {
            function1.invoke(obj);
        }
        this$0.dismiss();
        this$0.e0(2);
    }

    private final void c0() {
        int collectionSizeOrDefault;
        List listOf;
        List<SurpriseMatchPB$RecommendItem> list = this.rsp.items.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.items.get()");
        List<SurpriseMatchPB$RecommendItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((SurpriseMatchPB$RecommendItem) it.next()).reason.get());
        }
        List g06 = g0(arrayList);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TextView[]{(TextView) findViewById(R.id.os8), (TextView) findViewById(R.id.os9), (TextView) findViewById(R.id.os_)});
        int size = listOf.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TextView) listOf.get(i3)).setText((CharSequence) g06.get(i3));
        }
    }

    private final <T> List<T> g0(List<? extends T> list) {
        List<T> take;
        List<T> plus;
        take = CollectionsKt___CollectionsKt.take(list, 3);
        if (take.size() >= 3) {
            return take;
        }
        List<T> list2 = take;
        int size = 3 - take.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(null);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList);
        return plus;
    }

    private final void i0(TextView greetingTextTv) {
        int size = this.rsp.greet_text.get().size();
        if (size <= 0) {
            return;
        }
        int nextInt = new Random().nextInt(size);
        if (nextInt == this.greetingTextIndex) {
            nextInt = (nextInt + 1) % size;
        }
        this.greetingTextIndex = nextInt;
        String str = this.rsp.greet_text.get().get(nextInt);
        CharSequence text = greetingTextTv.getText();
        String obj = text != null ? text.toString() : null;
        if (!(obj == null || obj.length() == 0) && !Intrinsics.areEqual(obj, str)) {
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            he0.b.l(alphaAnimation, R.anim.f154986ut);
            he0.b.l(alphaAnimation2, R.anim.f154986ut);
            alphaAnimation.setAnimationListener(new b(greetingTextTv, str, alphaAnimation2));
            greetingTextTv.startAnimation(alphaAnimation);
            return;
        }
        greetingTextTv.setText(str);
    }

    private final void initView() {
        S();
        b0();
        R();
        c0();
        Y();
        U();
        f0();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyd);
        initView();
    }

    private final void e0(int clickPos) {
        Object orNull;
        Map mapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("action_type", "click");
        pairArr[1] = TuplesKt.to("recommend_reason_id", this.rsp.sub_title.get());
        List<String> list = this.rsp.greet_text.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.greet_text.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, this.greetingTextIndex);
        String str = (String) orNull;
        if (str == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("copy_id", str);
        pairArr[3] = TuplesKt.to("click_pos", String.valueOf(clickPos));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_kl_surprise_match", mapOf);
    }

    private final void f0() {
        Object orNull;
        Map mapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("action_type", "imp");
        pairArr[1] = TuplesKt.to("recommend_reason_id", this.rsp.sub_title.get());
        List<String> list = this.rsp.greet_text.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.greet_text.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, this.greetingTextIndex);
        String str = (String) orNull;
        if (str == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("copy_id", str);
        pairArr[3] = TuplesKt.to("click_pos", "0");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_kl_surprise_match", mapOf);
    }

    private final void S() {
        String str;
        ImageView imageView = (ImageView) findViewById(R.id.oko);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option targetView = Option.obtain().setTargetView(imageView);
        n nVar = n.f245488a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (nVar.a(context)) {
            str = "https://downv6.qq.com/extendfriend/kl_recommend_dialog_bg_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/kl_recommend_dialog_bg.png";
        }
        Option failDrawable = targetView.setUrl(str).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        Intrinsics.checkNotNullExpressionValue(failDrawable, "obtain()\n               \u2026wable(Color.TRANSPARENT))");
        qQPicLoader.e(failDrawable, null);
        Option failDrawable2 = Option.obtain().setTargetView((ImageView) findViewById(R.id.okr)).setUrl("https://downv6.qq.com/extendfriend/kl_recommend_dialog_icon.png").setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        Intrinsics.checkNotNullExpressionValue(failDrawable2, "obtain()\n               \u2026wable(Color.TRANSPARENT))");
        qQPicLoader.e(failDrawable2, null);
    }

    private final void U() {
        findViewById(R.id.okp).setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.W(e.this, view);
            }
        }, 1, null));
        findViewById(R.id.oqv).setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.X(e.this, view);
            }
        }, 1, null));
    }

    private final void Y() {
        final TextView greetingTextTv = (TextView) findViewById(R.id.ory);
        ImageView imageView = (ImageView) findViewById(R.id.okx);
        TextView textView = (TextView) findViewById(R.id.f163142oj1);
        Intrinsics.checkNotNullExpressionValue(greetingTextTv, "greetingTextTv");
        i0(greetingTextTv);
        imageView.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(300, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.Z(e.this, greetingTextTv, view);
            }
        }));
        com.tencent.mobileqq.matchfriend.reborn.utils.b bVar = com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setBackground(bVar.a(context));
        textView.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.a0(greetingTextTv, this, view);
            }
        }, 1, null));
    }

    private final void b0() {
        ((TextView) findViewById(R.id.os6)).setText(this.rsp.sub_title.get());
    }

    private final void d0(ImageView imageView, String avatar) {
        if (avatar == null || avatar.length() == 0) {
            imageView.setImageDrawable(null);
            return;
        }
        Option option = Option.obtain().setTargetView(imageView).setUrl(avatar).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }
}
