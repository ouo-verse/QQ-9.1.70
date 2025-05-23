package com.tencent.mobileqq.guild.api.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory;
import com.tencent.mobileqq.guild.api.FeedListDelegateType;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListAvatarSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListMultiImageSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleImageSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleVideoSection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/a;", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateSectionFactory;", "", "b", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "sectionType", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "a", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", "delegateType", "", "e", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class a implements FeedListDelegateSectionFactory {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.api.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public /* synthetic */ class C7674a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214416a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f214417b;

        static {
            int[] iArr = new int[FeedListSectionType.values().length];
            try {
                iArr[FeedListSectionType.Desc.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedListSectionType.SingleImage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeedListSectionType.MultiImage.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeedListSectionType.ShareContent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FeedListSectionType.TencentDoc.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FeedListSectionType.Avatar.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FeedListSectionType.Bottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FeedListSectionType.Header.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FeedListSectionType.SingleVideo.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FeedListSectionType.ThirdPartyShareLink.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FeedListSectionType.Function.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FeedListSectionType.ThirdParty.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FeedListSectionType.SmallWorldVideo.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FeedListSectionType.Comment.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FeedListSectionType.Prefer.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[FeedListSectionType.LongFeedContent.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            f214416a = iArr;
            int[] iArr2 = new int[FeedListDelegateType.values().length];
            try {
                iArr2[FeedListDelegateType.PlainText.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[FeedListDelegateType.SimpleFeed.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[FeedListDelegateType.SingleImage.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[FeedListDelegateType.ThirdPartyShareLink.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[FeedListDelegateType.TencentDoc.ordinal()] = 5;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[FeedListDelegateType.SmallWorldVideo.ordinal()] = 6;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[FeedListDelegateType.SingleVideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[FeedListDelegateType.ThirdVideo.ordinal()] = 8;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[FeedListDelegateType.LongFeed.ordinal()] = 9;
            } catch (NoSuchFieldError unused25) {
            }
            f214417b = iArr2;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public Class<? extends Section<?>> a(@NotNull FeedListSectionType sectionType) {
        Intrinsics.checkNotNullParameter(sectionType, "sectionType");
        switch (C7674a.f214416a[sectionType.ordinal()]) {
            case 1:
                return FeedListDescSection.class;
            case 2:
                return FeedListSingleImageSection.class;
            case 3:
                return FeedListMultiImageSection.class;
            case 4:
                return com.tencent.mobileqq.guild.feed.feedlist.section.h.class;
            case 5:
                return com.tencent.mobileqq.guild.feed.feedlist.section.j.class;
            case 6:
                return FeedListAvatarSection.class;
            case 7:
                return FeedListBottomSection.class;
            case 8:
                return com.tencent.mobileqq.guild.feed.feedlist.section.f.class;
            case 9:
                return FeedListSingleVideoSection.class;
            case 10:
                return com.tencent.mobileqq.guild.feed.feedlist.section.l.class;
            case 11:
                return FeedListFunctionSection.class;
            case 12:
                return com.tencent.mobileqq.guild.feed.feedlist.section.k.class;
            case 13:
                return com.tencent.mobileqq.guild.feed.feedlist.section.i.class;
            case 14:
                return com.tencent.mobileqq.guild.feed.feedlist.section.c.class;
            case 15:
                return com.tencent.mobileqq.guild.feed.feedlist.section.g.class;
            case 16:
                return FeedListLongContentSection.class;
            default:
                return com.tencent.mobileqq.guild.feed.feedlist.section.d.class;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    public int b() {
        return R.layout.er7;
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public List<Class<? extends Section<?>>> c(@NotNull FeedListDelegateType feedListDelegateType) {
        return FeedListDelegateSectionFactory.DefaultImpls.d(this, feedListDelegateType);
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public HashMap<FeedListDelegateType, Integer> d() {
        return FeedListDelegateSectionFactory.DefaultImpls.e(this);
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public List<FeedListSectionType> e(@NotNull FeedListDelegateType delegateType) {
        List<FeedListSectionType> mutableListOf;
        List<FeedListSectionType> mutableListOf2;
        List<FeedListSectionType> mutableListOf3;
        List<FeedListSectionType> mutableListOf4;
        List<FeedListSectionType> mutableListOf5;
        List<FeedListSectionType> mutableListOf6;
        List<FeedListSectionType> mutableListOf7;
        List<FeedListSectionType> mutableListOf8;
        List<FeedListSectionType> mutableListOf9;
        Intrinsics.checkNotNullParameter(delegateType, "delegateType");
        switch (C7674a.f214417b[delegateType.ordinal()]) {
            case 1:
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf;
            case 2:
                mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.MultiImage, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf2;
            case 3:
                mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.SingleImage, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf3;
            case 4:
                mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.ThirdPartyShareLink, FeedListSectionType.ShareContent, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf4;
            case 5:
                mutableListOf5 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf5;
            case 6:
                mutableListOf6 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.SmallWorldVideo, FeedListSectionType.Comment, FeedListSectionType.ShareContent, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf6;
            case 7:
                mutableListOf7 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.SingleVideo, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf7;
            case 8:
                mutableListOf8 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.Desc, FeedListSectionType.ShareContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf8;
            case 9:
                mutableListOf9 = CollectionsKt__CollectionsKt.mutableListOf(FeedListSectionType.Avatar, FeedListSectionType.Header, FeedListSectionType.LongFeedContent, FeedListSectionType.Comment, FeedListSectionType.Bottom, FeedListSectionType.Function, FeedListSectionType.Prefer);
                return mutableListOf9;
            default:
                throw new IllegalArgumentException("unknown delegate type: " + delegateType);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public <Delegate> List<Delegate> f(@NotNull Function2<? super FeedListDelegateType, ? super List<? extends Class<? extends Section<?>>>, ? extends Delegate> function2) {
        return FeedListDelegateSectionFactory.DefaultImpls.c(this, function2);
    }

    @Override // com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    public void g(@NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull Function1<? super FeedListDelegateType, Integer> function1) {
        FeedListDelegateSectionFactory.DefaultImpls.a(this, recycledViewPool, function1);
    }
}
