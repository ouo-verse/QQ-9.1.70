package com.tencent.mobileqq.guild.feed.excellentcase.config;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$b;", "d", "", "isAccountRelated", "", "version", "", "onSend", "", "content", "e", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ExcellentCaseConfigParser extends BaseConfigParser<Config> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<String> f218575e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<HashMap<String, ArrayList<Companion.ImageInfo>>> f218576f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006RW\u0010\u0010\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\bj\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b`\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$a;", "", "", "MAIN_TEXT_DEFAULT$delegate", "Lkotlin/Lazy;", "d", "()Ljava/lang/String;", "MAIN_TEXT_DEFAULT", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$a$a;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "IMAGE_INFO_LIST_DEFAULT$delegate", "c", "()Ljava/util/HashMap;", "IMAGE_INFO_LIST_DEFAULT", "HEIGHT", "Ljava/lang/String;", "ID", "IMAGE_INFO_LIST", "LIGHT_THEME", "MAIN_TEXT", "NIGHT_THEME", "TAG", Global.TRACKING_URL, "WIDTH", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$a$a;", "", "", "a", "", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "b", "I", "getWidth", "()I", "width", "c", "getHeight", "height", "<init>", "(Ljava/lang/String;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes13.dex */
        public static final /* data */ class ImageInfo {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String url;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final int width;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final int height;

            public ImageInfo(@NotNull String url, int i3, int i16) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
                this.width = i3;
                this.height = i16;
            }

            public final boolean a() {
                boolean z16;
                if (this.url.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && this.width > 0 && this.height > 0) {
                    return true;
                }
                return false;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageInfo)) {
                    return false;
                }
                ImageInfo imageInfo = (ImageInfo) other;
                if (Intrinsics.areEqual(this.url, imageInfo.url) && this.width == imageInfo.width && this.height == imageInfo.height) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (((this.url.hashCode() * 31) + this.width) * 31) + this.height;
            }

            @NotNull
            public String toString() {
                return "ImageInfo(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HashMap<String, ArrayList<ImageInfo>> c() {
            return (HashMap) ExcellentCaseConfigParser.f218576f.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d() {
            return (String) ExcellentCaseConfigParser.f218575e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012:\b\u0002\u0010\u001f\u001a4\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0018`\u0017\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RT\u0010\u001f\u001a4\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0018`\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "a", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getMainText", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", "mainText", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/excellentcase/config/ExcellentCaseConfigParser$a$a;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/HashMap;", "getImageInfoList", "()Ljava/util/HashMap;", "setImageInfoList", "(Ljava/util/HashMap;)V", "imageInfoList", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Config implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String mainText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private HashMap<String, ArrayList<Companion.ImageInfo>> imageInfoList;

        public Config() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public final void a(@NotNull String content) {
            String str;
            JSONArray jSONArray;
            int i3;
            Intrinsics.checkNotNullParameter(content, "content");
            String str2 = "ExcellentCaseConfigParser";
            QLog.d("ExcellentCaseConfigParser", 1, "[parse] config: " + content);
            try {
                JSONObject jSONObject = new JSONObject(content);
                String optString = jSONObject.optString("mainText");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(MAIN_TEXT)");
                this.mainText = optString;
                JSONObject optJSONObject = jSONObject.optJSONObject("imageInfoList");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("lightTheme");
                    if (optJSONArray == null) {
                        str = "ExcellentCaseConfigParser";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(LIGHT_THEME)");
                        this.imageInfoList.remove("lightTheme");
                        HashMap<String, ArrayList<Companion.ImageInfo>> hashMap = this.imageInfoList;
                        ArrayList<Companion.ImageInfo> arrayList = new ArrayList<>();
                        int length = optJSONArray.length();
                        int i16 = 0;
                        while (i16 < length) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
                            if (optJSONObject2 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(i)");
                                jSONArray = optJSONArray;
                                i3 = length;
                                String optString2 = optJSONObject2.optString("url");
                                Intrinsics.checkNotNullExpressionValue(optString2, "info.optString(URL)");
                                str = str2;
                                try {
                                    Companion.ImageInfo imageInfo = new Companion.ImageInfo(optString2, optJSONObject2.optInt("width"), optJSONObject2.optInt("height"));
                                    if (imageInfo.a()) {
                                        arrayList.add(imageInfo);
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e(str, 1, "parse e:" + e);
                                    return;
                                }
                            } else {
                                jSONArray = optJSONArray;
                                str = str2;
                                i3 = length;
                            }
                            i16++;
                            optJSONArray = jSONArray;
                            length = i3;
                            str2 = str;
                        }
                        str = str2;
                        hashMap.put("lightTheme", arrayList);
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("nightTheme");
                    if (optJSONArray2 != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(NIGHT_THEME)");
                        this.imageInfoList.remove("nightTheme");
                        HashMap<String, ArrayList<Companion.ImageInfo>> hashMap2 = this.imageInfoList;
                        ArrayList<Companion.ImageInfo> arrayList2 = new ArrayList<>();
                        int length2 = optJSONArray2.length();
                        for (int i17 = 0; i17 < length2; i17++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i17);
                            if (optJSONObject3 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject3, "optJSONObject(i)");
                                String optString3 = optJSONObject3.optString("url");
                                Intrinsics.checkNotNullExpressionValue(optString3, "info.optString(URL)");
                                Companion.ImageInfo imageInfo2 = new Companion.ImageInfo(optString3, optJSONObject3.optInt("width"), optJSONObject3.optInt("height"));
                                if (imageInfo2.a()) {
                                    arrayList2.add(imageInfo2);
                                }
                            }
                        }
                        hashMap2.put("nightTheme", arrayList2);
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str = str2;
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            if (Intrinsics.areEqual(this.mainText, config.mainText) && Intrinsics.areEqual(this.imageInfoList, config.imageInfoList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.mainText.hashCode() * 31) + this.imageInfoList.hashCode();
        }

        @NotNull
        public String toString() {
            return "Config(mainText=" + this.mainText + ", imageInfoList=" + this.imageInfoList + ")";
        }

        public Config(@NotNull String mainText, @NotNull HashMap<String, ArrayList<Companion.ImageInfo>> imageInfoList) {
            Intrinsics.checkNotNullParameter(mainText, "mainText");
            Intrinsics.checkNotNullParameter(imageInfoList, "imageInfoList");
            this.mainText = mainText;
            this.imageInfoList = imageInfoList;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Config(String MAIN_TEXT_DEFAULT, HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(MAIN_TEXT_DEFAULT, (i3 & 2) != 0 ? ExcellentCaseConfigParser.INSTANCE.c() : hashMap);
            if ((i3 & 1) != 0) {
                MAIN_TEXT_DEFAULT = ExcellentCaseConfigParser.INSTANCE.d();
                Intrinsics.checkNotNullExpressionValue(MAIN_TEXT_DEFAULT, "MAIN_TEXT_DEFAULT");
            }
        }
    }

    static {
        Lazy<String> lazy;
        Lazy<HashMap<String, ArrayList<Companion.ImageInfo>>> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser$Companion$MAIN_TEXT_DEFAULT$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseApplication.getContext().getString(R.string.f144070ns);
            }
        });
        f218575e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, ArrayList<Companion.ImageInfo>>>() { // from class: com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser$Companion$IMAGE_INFO_LIST_DEFAULT$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, ArrayList<ExcellentCaseConfigParser.Companion.ImageInfo>> invoke() {
                HashMap<String, ArrayList<ExcellentCaseConfigParser.Companion.ImageInfo>> hashMapOf;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image1.png", 1140, 1272));
                arrayList.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image2.png", 1140, 1506));
                arrayList.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image3.png", 1140, 2379));
                Unit unit = Unit.INSTANCE;
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image1_dark.png", 1140, 1272));
                arrayList2.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image2_dark.png", 1140, 1506));
                arrayList2.add(new ExcellentCaseConfigParser.Companion.ImageInfo("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_example_image3_dark.png", 1140, 2379));
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("lightTheme", arrayList), TuplesKt.to("nightTheme", arrayList2));
                return hashMapOf;
            }
        });
        f218576f = lazy2;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Config defaultConfig() {
        QLog.d("ExcellentCaseConfigParser", 1, "get defaultConfig");
        return new Config(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Config parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        Config config = new Config(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            config.a(new String(content, UTF_8));
            QLog.d("ExcellentCaseConfigParser", 1, "[parse] config: " + config);
        } else {
            QLog.d("ExcellentCaseConfigParser", 1, "[parse] empty content");
        }
        return config;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("ExcellentCaseConfigParser", 1, "[onSend] version: ", version);
    }
}
