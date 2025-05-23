package com.tencent.qqnt.emotion.relatedemo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010*\u001a\u00020\u0006\u00a2\u0006\u0004\b4\u00105B\u0011\b\u0016\u0012\u0006\u00106\u001a\u00020\u000b\u00a2\u0006\u0004\b4\u00107J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010%R\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "Landroid/os/Parcelable;", "", "", "curFriendUin", "", "curType", "index", "", "e", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "Landroid/content/Context;", "context", "", "density", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "d", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "c", "()Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "setResultItem", "(Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;)V", "resultItem", "Landroid/graphics/drawable/Drawable;", "getSLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setSLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "sLoadingDrawable", "f", "I", "a", "()I", "setDefaultCount", "(I)V", "defaultCount", tl.h.F, "Ljava/lang/String;", "mCurFriendUin", "i", "mCurType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "setMReportPosition", "mReportPosition", "<init>", "(Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;I)V", "inParcel", "(Landroid/os/Parcel;)V", "CREATOR", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RelatedEmoSearchEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NTRelatedEmotionSearchResult.SearchResultItem resultItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable sLoadingDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int defaultCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mCurFriendUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mReportPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.RelatedEmoSearchEmoticonInfo$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion implements Parcelable.Creator<RelatedEmoSearchEmoticonInfo> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RelatedEmoSearchEmoticonInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RelatedEmoSearchEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RelatedEmoSearchEmoticonInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RelatedEmoSearchEmoticonInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RelatedEmoSearchEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new RelatedEmoSearchEmoticonInfo[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RelatedEmoSearchEmoticonInfo(@NotNull NTRelatedEmotionSearchResult.SearchResultItem resultItem, int i3) {
        Intrinsics.checkNotNullParameter(resultItem, "resultItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) resultItem, i3);
            return;
        }
        this.sLoadingDrawable = new ColorDrawable(DownloadCardView.COLOR_APP_NAME_DARK);
        this.mCurFriendUin = "";
        this.resultItem = resultItem;
        this.defaultCount = i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.defaultCount;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mReportPosition;
    }

    @Nullable
    public final NTRelatedEmotionSearchResult.SearchResultItem c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (NTRelatedEmotionSearchResult.SearchResultItem) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.resultItem;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 0;
    }

    public final void e(@NotNull String curFriendUin, int curType, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, curFriendUin, Integer.valueOf(curType), Integer.valueOf(index));
            return;
        }
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        this.mCurFriendUin = curFriendUin;
        this.mCurType = curType;
        this.mReportPosition = index;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    @NotNull
    public Drawable getDrawable(@Nullable Context context, float density) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable) iPatchRedirector.redirect((short) 14, this, context, Float.valueOf(density));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.sLoadingDrawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = true;
        NTRelatedEmotionSearchResult.SearchResultItem searchResultItem = this.resultItem;
        if (searchResultItem != null) {
            str = searchResultItem.b();
        } else {
            str = null;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(resultItem?.url, options)");
        return drawable2;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeInt(this.defaultCount);
        parcel.writeParcelable(this.resultItem, flags);
        parcel.writeString(this.mCurFriendUin);
        parcel.writeInt(this.mCurType);
        parcel.writeInt(this.mReportPosition);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelatedEmoSearchEmoticonInfo(@NotNull Parcel inParcel) {
        super(inParcel);
        Intrinsics.checkNotNullParameter(inParcel, "inParcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inParcel);
            return;
        }
        this.sLoadingDrawable = new ColorDrawable(DownloadCardView.COLOR_APP_NAME_DARK);
        this.mCurFriendUin = "";
        this.defaultCount = inParcel.readInt();
        this.resultItem = (NTRelatedEmotionSearchResult.SearchResultItem) inParcel.readParcelable(NTRelatedEmotionSearchResult.SearchResultItem.class.getClassLoader());
        this.mCurFriendUin = inParcel.readString();
        this.mCurType = inParcel.readInt();
        this.mReportPosition = inParcel.readInt();
    }
}
