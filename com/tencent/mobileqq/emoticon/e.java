package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.qqnt.kernel.nativeinterface.PullMomentType;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J$\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH&J\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/emoticon/e;", "Lcom/tencent/mobileqq/emoticon/d;", "Lcom/tencent/mobileqq/emoticon/QQSysFaceResImpl;", "c", "Lcom/tencent/mobileqq/emoticon/QQEmojiResImpl;", "b", "", "initConfig", "refreshConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/PullMomentType;", "pullMomentType", "", "fetchBaseSource", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "", "downloadResTypeList", "downloadEmoticonRes", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResReloader$IResReloadListener;", "lottieResReloadListener", "setLottieResReloadListener", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface e extends d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ void a(e eVar, PullMomentType pullMomentType, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    z17 = false;
                }
                eVar.refreshConfig(pullMomentType, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshConfig");
        }
    }

    @NotNull
    QQEmojiResImpl b();

    @NotNull
    QQSysFaceResImpl c();

    void downloadEmoticonRes(@NotNull List<Integer> downloadResTypeList);

    void initConfig();

    void refreshConfig();

    void refreshConfig(@NotNull PullMomentType pullMomentType, boolean fetchBaseSource, boolean force);

    void setLottieResReloadListener(@Nullable QQSysAndEmojiResReloader.IResReloadListener lottieResReloadListener);
}
