package com.tencent.mobileqq.search.business.contact.part;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.widget.ThemeFixSizeImageView;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import com.tencent.mobileqq.search.business.contact.part.BuddyContactsSearchDelegate;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wn2.ContactSearchModelNtBuddy;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/BuddyContactsSearchDelegate;", "Lcom/tencent/mobileqq/search/business/contact/part/c;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$a;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "ContactsSection", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class BuddyContactsSearchDelegate extends c<UIType.a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0016J,\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0018\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/BuddyContactsSearchDelegate$ContactsSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$a;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "remainingTasks", "type", "", "uin", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "data", "position", "", "", "payload", "r", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "Lhp2/a;", "e", "Lhp2/a;", "getBinding", "()Lhp2/a;", "setBinding", "(Lhp2/a;)V", "binding", "<init>", "()V", "f", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class ContactsSection extends Section<UIType.a> implements DecodeTaskCompletionListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy faceDecoder;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private hp2.a binding;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f282965a;

            static {
                int[] iArr = new int[UIType.CheckStatus.values().length];
                try {
                    iArr[UIType.CheckStatus.CHECKED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[UIType.CheckStatus.UNCHECKED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[UIType.CheckStatus.DISABLED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f282965a = iArr;
            }
        }

        public ContactsSection() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<IFaceDecoder>() { // from class: com.tencent.mobileqq.search.business.contact.part.BuddyContactsSearchDelegate$ContactsSection$faceDecoder$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final IFaceDecoder invoke() {
                    IQQAvatarService iQQAvatarService;
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface == null || (iQQAvatarService = (IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")) == null) {
                        return null;
                    }
                    return iQQAvatarService.getInstance(appInterface);
                }
            });
            this.faceDecoder = lazy;
        }

        private final IFaceDecoder q() {
            return (IFaceDecoder) this.faceDecoder.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(ContactsSection this$0, View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            m mVar = (m) SectionIOCKt.getIocInterface(this$0, m.class);
            if (mVar != null) {
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                mVar.b(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        @NotNull
        public int[] getViewStubLayoutId() {
            return new int[0];
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
            Object obj;
            com.tencent.mobileqq.search.model.k kVar;
            String str;
            ThemeFixSizeImageView themeFixSizeImageView;
            LinearLayout root;
            hp2.a aVar = this.binding;
            String str2 = null;
            if (aVar != null && (root = aVar.getRoot()) != null) {
                obj = root.getTag(R.id.kxb);
            } else {
                obj = null;
            }
            if (obj instanceof com.tencent.mobileqq.search.model.k) {
                kVar = (com.tencent.mobileqq.search.model.k) obj;
            } else {
                kVar = null;
            }
            if (kVar != null) {
                str = kVar.getUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, uin)) {
                if (kVar != null) {
                    str2 = kVar.getUin();
                }
                QLog.e("BuddyContactsSearchDelegate", 1, "DecodeTaskCompleted type = [" + type + "], uin = [" + uin + "]!=" + str2);
            }
            hp2.a aVar2 = this.binding;
            if (aVar2 != null && (themeFixSizeImageView = aVar2.f405514d) != null) {
                themeFixSizeImageView.setImageDrawable(SearchUtils.u(q(), kVar));
            }
        }

        @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
        public void onDestroy() {
            super.onDestroy();
            IFaceDecoder q16 = q();
            if (q16 != null) {
                q16.destory();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            if (containerView != null) {
                this.binding = hp2.a.e(containerView);
            }
            IFaceDecoder q16 = q();
            if (q16 != null) {
                q16.setDecodeTaskCompletionListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onBindData(@Nullable final UIType.a data, int position, @Nullable List<Object> payload) {
            com.tencent.mobileqq.search.model.k kVar;
            int i3;
            boolean z16;
            ContactsSearchItemData itemData;
            hp2.a aVar = this.binding;
            if (aVar != null) {
                if (data != null && (itemData = data.getItemData()) != null) {
                    kVar = itemData.getModel();
                } else {
                    kVar = null;
                }
                if (kVar != null) {
                    aVar.getRoot().setTag(R.id.kxb, kVar);
                    aVar.getRoot().setTag(R.id.f1194676x, data);
                    aVar.f405523m.setText(kVar.getTitleSpans());
                    aVar.f405522l.setText(kVar.getSubTitleSpans());
                    aVar.f405513c.setText(kVar.getDescription());
                    ImageView imageView = aVar.f405518h;
                    int i16 = 8;
                    if (kVar.r()) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    imageView.setVisibility(i3);
                    aVar.getRoot().setClickable(data.getClickable());
                    if (data.getClickable()) {
                        aVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.contact.part.a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                BuddyContactsSearchDelegate.ContactsSection.s(BuddyContactsSearchDelegate.ContactsSection.this, view);
                            }
                        });
                        aVar.getRoot().setAlpha(1.0f);
                    } else {
                        aVar.getRoot().setAlpha(0.3f);
                    }
                    if ((kVar instanceof wn2.q) || (kVar instanceof wn2.f) || (kVar instanceof wn2.a)) {
                        TextView textView = aVar.f405522l;
                        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
                    }
                    aVar.f405514d.setImageDrawable(SearchUtils.u(q(), kVar));
                    CharSequence description = kVar.getDescription();
                    Intrinsics.checkNotNullExpressionValue(description, "model.description");
                    if (description.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        aVar.f405513c.setVisibility(0);
                    } else {
                        aVar.f405513c.setVisibility(8);
                    }
                    aVar.f405523m.setVisibility(0);
                    if (kVar.getSubTitleSpans() != null) {
                        aVar.f405522l.setVisibility(0);
                        if (!(kVar instanceof wn2.c) && !(kVar instanceof wn2.b) && !(kVar instanceof wn2.j)) {
                            aVar.f405522l.setCompoundDrawables(null, null, null, null);
                        } else {
                            String uin = kVar.getUin();
                            Intrinsics.checkNotNullExpressionValue(uin, "model.getUin()");
                            if (!TextUtils.isEmpty(uin) && Utils.G(uin)) {
                                Drawable drawable = aVar.f405522l.getContext().getResources().getDrawable(R.drawable.br7);
                                Intrinsics.checkNotNullExpressionValue(drawable, "it.subTitle.getContext()\u2026able.public_account_tigs)");
                                drawable.setBounds(0, 0, ViewUtils.dpToPx(15.0f), ViewUtils.dpToPx(15.0f));
                                ThemeUtil.setThemeFilter(drawable, ThemeUtil.curThemeId);
                                aVar.f405522l.setCompoundDrawables(null, null, drawable, null);
                            } else {
                                aVar.f405522l.setCompoundDrawables(null, null, null, null);
                            }
                        }
                    } else {
                        aVar.f405522l.setVisibility(8);
                    }
                    TextView textView2 = aVar.f405520j;
                    Intrinsics.checkNotNullExpressionValue(textView2, "it.singleTitle");
                    textView2.setVisibility(8);
                    ImageView imageView2 = aVar.f405524n;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "it.tvRobot");
                    imageView2.setVisibility(8);
                    if ((kVar instanceof wn2.g) || (kVar instanceof wn2.n) || (kVar instanceof wn2.c) || (kVar instanceof ContactSearchModelNtBuddy)) {
                        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isRobotUin(kVar.getUin())) {
                            imageView2.setVisibility(0);
                        }
                    }
                    RelativeLayout relativeLayout = aVar.f405519i;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout, "it.rlCheckbox");
                    if (data.getCanEditCheckStatus()) {
                        i16 = 0;
                    }
                    relativeLayout.setVisibility(i16);
                    int i17 = b.f282965a[data.getCheckStatus().ordinal()];
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 == 3) {
                                aVar.f405512b.setChecked(true);
                                aVar.f405512b.setEnabled(false);
                            }
                        } else {
                            aVar.f405512b.setChecked(false);
                            aVar.f405512b.setEnabled(true);
                        }
                    } else {
                        aVar.f405512b.setChecked(true);
                        aVar.f405512b.setEnabled(true);
                    }
                    ThemeFixSizeImageView themeFixSizeImageView = aVar.f405514d;
                    Intrinsics.checkNotNullExpressionValue(themeFixSizeImageView, "it.image");
                    com.tencent.mobileqq.search.searchdetail.multimedia.p.a(themeFixSizeImageView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.BuddyContactsSearchDelegate$ContactsSection$onBindData$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                            invoke2(layoutParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull RelativeLayout.LayoutParams updateLayoutParams) {
                            Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                            updateLayoutParams.leftMargin = ViewUtils.dpToPx(UIType.a.this.getCanEditCheckStatus() ? 12.0f : 16.0f);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull UIType item, @NotNull List<UIType> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof UIType.a;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.e4a;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<UIType.a>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(ContactsSection.class);
    }
}
