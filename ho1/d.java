package ho1;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f405441a = Pattern.compile("\\d+");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f405442b = ((IQzoneEmotionUtilsApi) QRoute.api(IQzoneEmotionUtilsApi.class)).getSmileyPattern();

    public static void a(View view, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        if (view instanceof SystemAndEmojiUniversalPanel) {
            systemAndEmojiEmoticonInfo.addToCommonUsed(((SystemAndEmojiUniversalPanel) view).getApp(), (Parcelable) null);
        } else {
            systemAndEmojiEmoticonInfo.addToCommonUsed(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()), (Parcelable) null);
        }
    }

    public static String b(int i3, int i16) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16);
    }

    public static View c(Context context, EditText editText, EmoticonCallback emoticonCallback) {
        return new SystemAndEmojiUniversalPanel.Builder(context).setEmoticonCallback(emoticonCallback).setShowCommonUsedSystemEmoji(true).setShowDeleteButton(editText).setForeSplitLottieSticker(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()), true);
    }

    public static String d(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }
}
