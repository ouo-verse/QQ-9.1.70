package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/o;", "", "", "current", "target", "Landroid/content/Context;", "context", "", "b", "tag", "Landroid/widget/ImageView;", "imageView", "url", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "f", "token", "Landroid/graphics/drawable/Drawable;", "e", "tokenName", "", "c", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Integer;", "", "ratio", "d", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "mTokenIdCache", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class o {

    /* renamed from: a */
    @NotNull
    public static final o f284545a = new o();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> mTokenIdCache = new HashMap<>();

    o() {
    }

    public static /* synthetic */ void g(o oVar, String str, ImageView imageView, String str2, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            iPicLoadStateListener = null;
        }
        oVar.f(str, imageView, str2, iPicLoadStateListener);
    }

    public static final void h(IPicLoadStateListener iPicLoadStateListener, LoadState loadState, Option option) {
        r01.c cVar;
        Animatable animatable = option.getAnimatable();
        if (animatable instanceof r01.c) {
            cVar = (r01.c) animatable;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.setLoopCount(65535);
        }
        if (cVar != null) {
            cVar.start();
        }
        if (iPicLoadStateListener != null) {
            iPicLoadStateListener.onStateChange(loadState, option);
        }
    }

    @NotNull
    public final String b(long current, long target, @NotNull Context context) {
        String result;
        Intrinsics.checkNotNullParameter(context, "context");
        long max = Math.max(0L, current - target);
        if (max <= 60000) {
            result = context.getString(R.string.f224456iz);
        } else if (max <= 3600000) {
            result = (max / 60000) + "\u5206\u949f\u524d";
        } else if (max <= 86400000) {
            result = (max / 3600000) + "\u5c0f\u65f6\u524d";
        } else if (max <= 604800000) {
            result = (max / 86400000) + "\u5929\u524d";
        } else {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(target);
            if (calendar2.get(1) == calendar.get(1)) {
                result = new SimpleDateFormat("MM-dd").format(calendar2.getTime());
            } else {
                result = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(calendar2.getTime());
            }
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @Nullable
    public final Integer c(@NotNull String tokenName, @NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(tokenName, "tokenName");
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
        if (currentTokenMap == null || (str = currentTokenMap.get(tokenName)) == null) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public final int d(float ratio) {
        if (ratio <= 0.5625f) {
            return 0;
        }
        if (ratio <= 0.75f) {
            return 1;
        }
        if (ratio < 1.3333334f) {
            return 2;
        }
        if (ratio < 1.7777778f) {
            return 3;
        }
        return 4;
    }

    @Nullable
    public final Drawable e(@NotNull Context context, @NotNull String token) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        if (!TextUtils.isEmpty(token)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(token, "qui_", false, 2, null);
            if (!startsWith$default) {
                token = "qui_" + token;
            }
            HashMap<String, Integer> hashMap = mTokenIdCache;
            Integer num = hashMap.get(token);
            try {
                if (num != null) {
                    return cn.f(ResourcesCompat.getDrawable(context.getResources(), num.intValue(), null));
                }
                Integer valueOf = Integer.valueOf(context.getResources().getIdentifier(token, "drawable", context.getPackageName()));
                hashMap.put(token, valueOf);
                return cn.f(ResourcesCompat.getDrawable(context.getResources(), valueOf.intValue(), null));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public final void f(@NotNull String tag, @NotNull ImageView imageView, @NotNull String url, @Nullable final IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = Option.obtain().setUrl(url).setTargetView(imageView).setRegionScaleType(imageView.getScaleType()).setDecodeMode(1);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.n
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                o.h(IPicLoadStateListener.this, loadState, option2);
            }
        });
    }
}
