package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/QQUnicomCardGuideConfig;", "", "()V", "BASE_URL", "", "ENTRY_DEFAULT_MAPS", "", "Lcom/tencent/mobileqq/vas/qqmc/EntryItem;", "ENTRY_KEYS", "", "getENTRY_KEYS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "GUIDE_ENTRY_JUMPURL", "GUIDE_ENTRY_KEYWORD", "GUIDE_ENTRY_TIP", "GUIDE_SWITCH", "TAG", "configEnable", "", "getEntryItem", "keyName", QQUnicomCardGuideConfig.GUIDE_SWITCH, "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QQUnicomCardGuideConfig {

    @NotNull
    private static final String BASE_URL = "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&";

    @NotNull
    private static final Map<String, EntryItem> ENTRY_DEFAULT_MAPS;

    @NotNull
    private static final String GUIDE_ENTRY_JUMPURL = "jump_url";

    @NotNull
    private static final String GUIDE_ENTRY_KEYWORD = "key_word";

    @NotNull
    private static final String GUIDE_ENTRY_TIP = "tip";

    @NotNull
    private static final String GUIDE_SWITCH = "isNeedShowGuide";

    @NotNull
    private static final String TAG = "QQUnicomCardGuideConfig";
    private static final boolean configEnable;

    @NotNull
    public static final QQUnicomCardGuideConfig INSTANCE = new QQUnicomCardGuideConfig();

    @NotNull
    private static final String[] ENTRY_KEYS = {"entry_setting", "entry_aio_video", "entry_file", "entry_chat_audio", "entry_chat_video", "entry_kandian_video"};

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TuplesKt.to("entry_setting", new EntryItem("QQ\u514d\u6d41\u91cf", "", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=setting"));
        TuplesKt.to("entry_aio_video", new EntryItem("", "", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=aio_video"));
        TuplesKt.to("entry_file", new EntryItem("", "", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=file"));
        TuplesKt.to("entry_chat_audio", new EntryItem("", "\u6d41\u91cf\u4e0d\u8db3|\u6d41\u91cf\u4e0d\u591f|\u514d\u6d41\u91cf|\u624b\u673a\u5361", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=chat_audio"));
        TuplesKt.to("entry_chat_video", new EntryItem("", "\u6d41\u91cf\u4e0d\u8db3|\u6d41\u91cf\u4e0d\u591f|\u514d\u6d41\u91cf|\u624b\u673a\u5361", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=chat_video"));
        TuplesKt.to("entry_kandian_video", new EntryItem("", "", "https://club.vip.qq.com/qqvip/telecom/home?_wv=16777221&_wwv=8192&_proxy=1&channelFrom=kandian_video"));
        ENTRY_DEFAULT_MAPS = linkedHashMap;
        configEnable = VasLongToggle.VAS_UNICOM_KING_TIPS_CONFIG.isEnable(true);
    }

    QQUnicomCardGuideConfig() {
    }

    @NotNull
    public final String[] getENTRY_KEYS() {
        return ENTRY_KEYS;
    }

    @Nullable
    public final EntryItem getEntryItem(@NotNull String keyName) {
        String str;
        String str2;
        String jumpUrl;
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        EntryItem entryItem = ENTRY_DEFAULT_MAPS.get(keyName);
        if (!configEnable) {
            return entryItem;
        }
        try {
            String stringDataSet = VasLongToggle.VAS_UNICOM_KING_TIPS_CONFIG.getStringDataSet(keyName, null);
            if (stringDataSet == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(stringDataSet);
            String str3 = "";
            if (entryItem == null || (str = entryItem.getTip()) == null) {
                str = "";
            }
            String g16 = com.tencent.mobileqq.perf.tool.b.g(jSONObject, GUIDE_ENTRY_TIP, str);
            if (entryItem == null || (str2 = entryItem.getKeyWord()) == null) {
                str2 = "";
            }
            String g17 = com.tencent.mobileqq.perf.tool.b.g(jSONObject, "key_word", str2);
            if (entryItem != null && (jumpUrl = entryItem.getJumpUrl()) != null) {
                str3 = jumpUrl;
            }
            return new EntryItem(g16, g17, com.tencent.mobileqq.perf.tool.b.g(jSONObject, "jump_url", str3));
        } catch (Exception e16) {
            QLog.e(TAG, 1, keyName + " parse error " + e16);
            return entryItem;
        }
    }

    public final boolean isNeedShowGuide() {
        if (!configEnable) {
            return false;
        }
        return Intrinsics.areEqual(VasLongToggle.VAS_UNICOM_KING_TIPS_CONFIG.getStringDataSet(GUIDE_SWITCH, "true"), "true");
    }
}
