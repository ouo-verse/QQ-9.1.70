package com.tencent.qqnt.chathistory.ui.sticker.data.model;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.utils.m;
import com.tencent.qqnt.chathistory.util.PicSize;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.f;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B'\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u00102J\u0014\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010,\u001a\u00020(8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020(8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b-\u0010+R\u0017\u00100\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b*\u0010)\u001a\u0004\b/\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "", "Landroid/widget/ImageView;", "", "path", "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", DomainData.DOMAIN_NAME, "iv", "Lkotlinx/coroutines/CoroutineScope;", "scope", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "i", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "f", "I", h.F, "()I", "chatType", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "peerId", "", "J", "j", "()J", "msgId", "a", "msgTime", "k", "msgSeq", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;ILjava/lang/String;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class SearchStickerItemModel extends com.tencent.qqnt.chathistory.ui.base.item.b {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final a f353916k;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord record;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgElement element;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f353916k = new a(null);
        }
    }

    public SearchStickerItemModel(@NotNull MsgRecord record, @NotNull MsgElement element, int i3, @NotNull String peerId) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, record, element, Integer.valueOf(i3), peerId);
            return;
        }
        this.record = record;
        this.element = element;
        this.chatType = i3;
        this.peerId = peerId;
        this.msgId = record.msgId;
        this.msgTime = record.msgTime;
        this.msgSeq = record.msgSeq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ImageView imageView, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(HippyBridge.URI_SCHEME_FILE + str, obtain);
        drawable.downloadImediatly(true);
        imageView.setImageDrawable(drawable);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.msgTime;
    }

    public final void g(@NotNull final ImageView iv5, @NotNull final CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iv5, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (p()) {
            d.f354054a.a("SearchStickerItemModel", "\u5546\u573a\u8868\u60c5");
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new SearchStickerItemModel$applyView$1(this, iv5, null), 3, null);
        } else {
            if (!q() && !o()) {
                return;
            }
            if (q()) {
                d.f354054a.a("SearchStickerItemModel", "\u56fe\u6587\u6df7\u6392\u8868\u60c5");
            } else {
                d.f354054a.a("SearchStickerItemModel", "\u6587\u4ef6\u8868\u60c5");
            }
            final String i3 = com.tencent.qqnt.chathistory.util.a.i(this.element, PicSize.PIC_DOWNLOAD_ORI);
            f.b(i3, new Function0<Unit>(iv5, scope) { // from class: com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ImageView $iv;
                final /* synthetic */ CoroutineScope $scope;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$2$1", f = "SearchStickerItemModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$2$1, reason: invalid class name */
                /* loaded from: classes23.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ImageView $iv;
                    private /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ SearchStickerItemModel this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$2$1$1", f = "SearchStickerItemModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes23.dex */
                    public static final class C95531 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ CoroutineScope $$this$launch;
                        final /* synthetic */ ImageView $iv;
                        /* synthetic */ Object L$0;
                        int label;
                        final /* synthetic */ SearchStickerItemModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C95531(ImageView imageView, CoroutineScope coroutineScope, SearchStickerItemModel searchStickerItemModel, Continuation<? super C95531> continuation) {
                            super(2, continuation);
                            this.$iv = imageView;
                            this.$$this$launch = coroutineScope;
                            this.this$0 = searchStickerItemModel;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, imageView, coroutineScope, searchStickerItemModel, continuation);
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                            }
                            C95531 c95531 = new C95531(this.$iv, this.$$this$launch, this.this$0, continuation);
                            c95531.L$0 = obj;
                            return c95531;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @Nullable Continuation<? super Unit> continuation) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((C95531) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileTransNotifyInfo, (Object) continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            b bVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    FileTransNotifyInfo fileTransNotifyInfo = (FileTransNotifyInfo) this.L$0;
                                    Object tag = this.$iv.getTag(R.id.f164778tt4);
                                    if (tag instanceof b) {
                                        bVar = (b) tag;
                                    } else {
                                        bVar = null;
                                    }
                                    if (bVar != null) {
                                        CoroutineScope coroutineScope = this.$$this$launch;
                                        SearchStickerItemModel searchStickerItemModel = this.this$0;
                                        ImageView imageView = this.$iv;
                                        if (fileTransNotifyInfo != null && bVar.b() == fileTransNotifyInfo.msgId && bVar.a() == fileTransNotifyInfo.msgElementId) {
                                            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
                                            String str = fileTransNotifyInfo.filePath;
                                            Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                                            searchStickerItemModel.r(imageView, str);
                                            if (searchStickerItemModel.q()) {
                                                searchStickerItemModel.i().picElement.sourcePath = fileTransNotifyInfo.filePath;
                                            } else if (searchStickerItemModel.o()) {
                                                searchStickerItemModel.i().fileElement.filePath = fileTransNotifyInfo.filePath;
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ImageView imageView, SearchStickerItemModel searchStickerItemModel, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$iv = imageView;
                        this.this$0 = searchStickerItemModel;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, imageView, searchStickerItemModel, continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$iv, this.this$0, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                FlowKt.launchIn(FlowKt.onEach(com.tencent.qqnt.chathistory.service.d.f(), new C95531(this.$iv, coroutineScope, this.this$0, null)), coroutineScope);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$iv = iv5;
                    this.$scope = scope;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchStickerItemModel.this, iv5, scope);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String i16 = com.tencent.qqnt.chathistory.util.a.i(SearchStickerItemModel.this.i(), PicSize.PIC_DOWNLOAD_THUMB);
                    if (m.e(i16)) {
                        d.f354054a.a("SearchStickerItemModel", "loadThumbPath " + i16);
                        SearchStickerItemModel.this.r(this.$iv, i16);
                        return;
                    }
                    this.$iv.setTag(R.id.f164778tt4, new b(SearchStickerItemModel.this.m().msgId, SearchStickerItemModel.this.i().elementId));
                    BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(this.$iv, SearchStickerItemModel.this, null), 3, null);
                    Pair<Integer, Integer> f16 = com.tencent.qqnt.chathistory.util.a.f(SearchStickerItemModel.this.i(), PicSize.PIC_DOWNLOAD_ORI);
                    w e16 = com.tencent.qqnt.msg.f.e();
                    if (e16 != null) {
                        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
                        SearchStickerItemModel searchStickerItemModel = SearchStickerItemModel.this;
                        richMediaElementGetReq.msgId = searchStickerItemModel.m().msgId;
                        richMediaElementGetReq.peerUid = searchStickerItemModel.l();
                        richMediaElementGetReq.chatType = searchStickerItemModel.h();
                        richMediaElementGetReq.elementId = searchStickerItemModel.i().elementId;
                        richMediaElementGetReq.downloadType = f16.getFirst().intValue();
                        richMediaElementGetReq.thumbSize = f16.getSecond().intValue();
                        richMediaElementGetReq.downSourceType = 3;
                        richMediaElementGetReq.triggerType = 1;
                        e16.getRichMediaElement(richMediaElementGetReq);
                    }
                }
            }, new Function1<File, Unit>(iv5, i3) { // from class: com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel$applyView$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ ImageView $iv;
                final /* synthetic */ String $picImagePath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$iv = iv5;
                    this.$picImagePath = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SearchStickerItemModel.this, iv5, i3);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(File file) {
                    invoke2(file);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull File it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        SearchStickerItemModel.this.r(this.$iv, this.$picImagePath);
                    }
                }
            });
        }
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.chatType;
    }

    @NotNull
    public final MsgElement i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.element;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.msgId;
    }

    public final long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.msgSeq;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.peerId;
    }

    @NotNull
    public final MsgRecord m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.record;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (!q() && !p() && !o()) {
            return false;
        }
        return true;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.record.msgType == 3 && this.element.fileElement != null) {
            return true;
        }
        return false;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.record.msgType == 17 && this.element.marketFaceElement != null) {
            return true;
        }
        return false;
    }

    public final boolean q() {
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.record.msgType == 2 && (picElement = this.element.picElement) != null) {
            Intrinsics.checkNotNullExpressionValue(picElement, "element.picElement");
            if (MsgExtKt.u(picElement)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
