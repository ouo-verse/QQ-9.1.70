package com.tencent.qqnt.emotion.data;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.emotion.text.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/emotion/data/b;", "", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/emotion/data/b$a;", "", "", "", "orderList", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "e", "b", "", "showEmoji", "f", "info", "Landroid/graphics/drawable/Drawable;", "d", "a", "", "c", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.data.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        private final List<SystemAndEmojiEmotionInfo> b(List<Integer> orderList) {
            ArrayList arrayList = new ArrayList();
            if (orderList != null && !orderList.isEmpty()) {
                String string = MobileQQ.sMobileQQ.getString(R.string.yer);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(\n   \u2026ng.Emotion_EmojiEmoticon)");
                arrayList.add(new SystemAndEmojiEmotionInfo(3, -1, string));
                Iterator<Integer> it = orderList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new SystemAndEmojiEmotionInfo(2, it.next().intValue(), ""));
                }
            }
            return arrayList;
        }

        private final List<SystemAndEmojiEmotionInfo> e(List<Integer> orderList) {
            ArrayList arrayList = new ArrayList();
            if (orderList != null && !orderList.isEmpty()) {
                String string = MobileQQ.sMobileQQ.getString(R.string.yeo);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.string.Emotion_AllEmotion)");
                arrayList.add(new SystemAndEmojiEmotionInfo(3, -1, string));
                int size = orderList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (orderList.get(i3).intValue() == -1) {
                        arrayList.add(new SystemAndEmojiEmotionInfo(1, 0, ""));
                    } else {
                        arrayList.add(new SystemAndEmojiEmotionInfo(1, orderList.get(i3).intValue(), ""));
                    }
                }
            }
            return arrayList;
        }

        @Nullable
        public final Drawable a(@NotNull SystemAndEmojiEmotionInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.c() == 1 && info.getCode() != -1) {
                return c.b(info.getCode(), true);
            }
            if (info.c() == 2 && info.getCode() != -1) {
                return info.b();
            }
            return null;
        }

        @Nullable
        public final String c(@Nullable SystemAndEmojiEmotionInfo info) {
            String str;
            boolean startsWith$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            }
            if (info != null) {
                if (info.c() == 1) {
                    str = QQSysFaceUtil.getFaceDescription(info.getCode());
                } else if (info.c() == 2) {
                    str = QQEmojiUtil.getEmojiDescription(info.getCode());
                } else {
                    str = null;
                }
                if (str != null && str.length() > 1) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "/", false, 2, null);
                    if (startsWith$default) {
                        String substring = str.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    return str;
                }
                return str;
            }
            return "";
        }

        @Nullable
        public final Drawable d(@NotNull SystemAndEmojiEmotionInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            int c16 = info.c();
            if (c16 != 1) {
                if (c16 != 2) {
                    return null;
                }
                return QQEmojiUtil.getEmojiDrawable(info.getCode());
            }
            return QQSysFaceUtil.getFaceDrawable(info.getCode());
        }

        @NotNull
        public final List<SystemAndEmojiEmotionInfo> f(boolean showEmoji) {
            ArrayList arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, showEmoji);
            }
            ArrayList<Integer> orderList = QQSysFaceUtil.getOrderList();
            Intrinsics.checkNotNullExpressionValue(orderList, "getOrderList()");
            ArrayList<Integer> orderList2 = QQEmojiUtil.getOrderList();
            Intrinsics.checkNotNullExpressionValue(orderList2, "getOrderList()");
            if (showEmoji) {
                arrayList = new ArrayList(orderList.size() + orderList2.size());
            } else {
                arrayList = new ArrayList(orderList.size());
            }
            arrayList.addAll(e(orderList));
            if (showEmoji) {
                arrayList.addAll(b(orderList2));
            }
            return arrayList;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
