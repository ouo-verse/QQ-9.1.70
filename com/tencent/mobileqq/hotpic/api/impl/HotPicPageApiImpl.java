package com.tencent.mobileqq.hotpic.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.NTHotPicPageView;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.an;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/hotpic/api/impl/HotPicPageApiImpl;", "Lcom/tencent/mobileqq/hotpic/api/IHotPicPageApi;", "()V", "checkAndDownLoadHotPic", "", "hotPicData", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "getHotPicDrawable", "Lcom/tencent/image/URLDrawable;", "searchInfoToSearchItem", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "emojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class HotPicPageApiImpl implements IHotPicPageApi {
    static IPatchRedirector $redirector_;

    public HotPicPageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicPageApi
    public int checkAndDownLoadHotPic(@NotNull HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotPicData)).intValue();
        }
        Intrinsics.checkNotNullParameter(hotPicData, "hotPicData");
        return NTHotPicPageView.f(hotPicData);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicPageApi
    @Nullable
    public URLDrawable getHotPicDrawable(@NotNull HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hotPicData);
        }
        Intrinsics.checkNotNullParameter(hotPicData, "hotPicData");
        return NTHotPicPageView.h(hotPicData);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicPageApi
    @NotNull
    public EmotionSearchItem searchInfoToSearchItem(@NotNull EmojiHotPicSearchEmojiInfo emojiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmotionSearchItem) iPatchRedirector.redirect((short) 3, (Object) this, (Object) emojiInfo);
        }
        Intrinsics.checkNotNullParameter(emojiInfo, "emojiInfo");
        return an.f306578a.a(emojiInfo);
    }
}
