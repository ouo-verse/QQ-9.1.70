package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.shimmerview.QUIShimmerUrlImageView;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextComposeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchCompositeEmoLinearLayout;", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout;", "mContext", "Landroid/content/Context;", "mColumnNum", "", "mSearchEmoLinearLayoutCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;", "mShimmerController", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "(Landroid/content/Context;ILcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;)V", "createImageView", "Lcom/tencent/mobileqq/qui/shimmerview/QUIShimmerUrlImageView;", "handleExtra", "", "imageView", "emoticonInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchCompositeEmoLinearLayout extends SearchEmoLinearLayout {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "SearchCompositeEmoLinearLayout";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchCompositeEmoLinearLayout$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchCompositeEmoLinearLayout(@NotNull Context mContext, int i3, @NotNull SearchEmoLinearLayout.SearchEmoLinearLayoutCb mSearchEmoLinearLayoutCb, @Nullable QUIShimmerController qUIShimmerController) {
        super(mContext, i3, mSearchEmoLinearLayoutCb, qUIShimmerController);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mSearchEmoLinearLayoutCb, "mSearchEmoLinearLayoutCb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, Integer.valueOf(i3), mSearchEmoLinearLayoutCb, qUIShimmerController);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout
    @NotNull
    public QUIShimmerUrlImageView createImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIShimmerUrlImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        CompositeURLImageView compositeURLImageView = new CompositeURLImageView(getMContext(), null, 0, 6, null);
        compositeURLImageView.setTypeface(getMSearchEmoLinearLayoutCb().getTypeface());
        return compositeURLImageView;
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout
    public void handleExtra(@NotNull QUIShimmerUrlImageView imageView, @NotNull EmoticonInfo emoticonInfo) {
        CompositeURLImageView compositeURLImageView;
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView, (Object) emoticonInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(emoticonInfo, "emoticonInfo");
        EmojiHotPicSearchTextComposeInfo emojiHotPicSearchTextComposeInfo = null;
        if (imageView instanceof CompositeURLImageView) {
            compositeURLImageView = (CompositeURLImageView) imageView;
        } else {
            compositeURLImageView = null;
        }
        if (compositeURLImageView == null) {
            return;
        }
        if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
            hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emoticonInfo;
        } else {
            hotPicSearchEmoticonInfo = null;
        }
        if (hotPicSearchEmoticonInfo == null || (str = hotPicSearchEmoticonInfo.mSearchWord) == null) {
            return;
        }
        EmotionSearchItem emotionSearchItem = hotPicSearchEmoticonInfo.mSearchItem;
        if (emotionSearchItem != null) {
            emojiHotPicSearchTextComposeInfo = emotionSearchItem.textComposeInfo;
        }
        if (emojiHotPicSearchTextComposeInfo == null) {
            return;
        }
        compositeURLImageView.setTextComposeInfo(str, emojiHotPicSearchTextComposeInfo);
    }
}
