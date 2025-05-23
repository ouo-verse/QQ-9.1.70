package g73;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lg73/a;", "", "Landroid/view/View;", "musicButton", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "winkEditorMusicInfo", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f401518a = new a();

    a() {
    }

    public final void a(@Nullable View musicButton, @Nullable WinkEditorMusicInfo winkEditorMusicInfo) {
        String str;
        if (musicButton != null) {
            String str2 = "";
            if (winkEditorMusicInfo == null) {
                str = "";
            } else {
                str = winkEditorMusicInfo.q();
                if (TextUtils.isEmpty(str)) {
                    long o16 = winkEditorMusicInfo.o();
                    Long l3 = WinkEditorMusicInfo.H;
                    if (l3 != null && o16 == l3.longValue()) {
                        str = BaseApplication.getContext().getString(R.string.ym_);
                    }
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (str != null) {
                str2 = str;
            }
            linkedHashMap.put("xsj_music_name", str2);
            e.r(e.f326265a, "dt_imp", musicButton, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON, linkedHashMap, null, 16, null);
        }
    }
}
