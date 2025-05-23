package com.qzone.reborn.groupalbum.selectmedia.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaModel;
import com.qzone.reborn.groupalbum.selectmedia.util.HistoryException;
import com.qzone.reborn.groupalbum.selectmedia.util.e;
import com.qzone.reborn.groupalbum.selectmedia.util.f;
import com.qzone.reborn.groupalbum.selectmedia.util.g;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yi.DownLoadParam;
import yi.MultiPayLoad;
import yi.PicPayLoad;
import yi.d;
import yi.i;
import yi.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0003DEFBl\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110>\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060\u000e\u00126\u0010 \u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060\u001d\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J2\u0010\u0013\u001a\u00020\f2'\b\u0002\u0010\u0012\u001a!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000eH\u0096\u0001J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096\u0001Ji\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\b26\u0010 \u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\"\u001a\u00020!H\u0096\u0001J\u001e\u0010'\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00142\u0006\u0010&\u001a\u00020\u0003H\u0014J\b\u0010)\u001a\u0004\u0018\u00010(J\b\u0010+\u001a\u0004\u0018\u00010*R\u0014\u0010.\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-RG\u0010 \u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060\u001d8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter;", "Lxi/b;", "", "", "U0", "Landroid/widget/ImageView;", "", "T0", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "", "msgId", "", "R0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "callBack", "S0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Z0", "Landroid/view/View;", "itemView", "msgRecord", "Lzi/b;", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "b1", "Lwi/b;", "data", "position", "o0", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaModel;", "Y0", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "X0", "G", "I", "source", "H", "Lkotlin/jvm/functions/Function2;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lkotlin/jvm/functions/Function2;", "Landroid/graphics/drawable/ColorDrawable;", "J", "Lkotlin/Lazy;", "V0", "()Landroid/graphics/drawable/ColorDrawable;", "defaultDrawable", "Landroid/graphics/drawable/Drawable;", "K", "W0", "()Landroid/graphics/drawable/Drawable;", "failedDrawable", "Lyi/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "sendIntent", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "L", "a", "ContentItemProvider", "ContentVideoItemProvider", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaAdapter extends xi.b {

    /* renamed from: G, reason: from kotlin metadata */
    private final int source;

    /* renamed from: H, reason: from kotlin metadata */
    private final Function2<Boolean, Boolean, Unit> setBottomBarState;
    private final /* synthetic */ i I;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy defaultDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy failedDrawable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R2\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter$ContentItemProvider;", "Lxi/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "helper", "Lwi/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lyi/a;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "o", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "", "f", "()I", "itemViewType", "<init>", "(Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter;Lkotlin/jvm/functions/Function1;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class ContentItemProvider extends xi.c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final Function1<DownLoadParam, Unit> sendIntent;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatHistorySelectMediaAdapter f56907d;

        /* JADX WARN: Multi-variable type inference failed */
        public ContentItemProvider(ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter, Function1<? super DownLoadParam, Unit> sendIntent) {
            Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
            this.f56907d = chatHistorySelectMediaAdapter;
            this.sendIntent = sendIntent;
        }

        @Override // xi.a
        public View c(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f127811o, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026adapter_item_media, null)");
            return inflate;
        }

        @Override // xi.a
        public int f() {
            return 1;
        }

        @Override // xi.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(a helper, wi.b item, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            final ImageView imageView = (ImageView) helper.getView(R.id.lvd);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.mhy);
            qUICheckBox.setType(3);
            qUICheckBox.setClickable(false);
            ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1 chatHistorySelectMediaAdapter$ContentItemProvider$convert$1 = new ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1(this.f56907d, imageView, helper, qUICheckBox, this);
            final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter = this.f56907d;
            com.qzone.reborn.groupalbum.selectmedia.util.b.a(this, item, payloads, chatHistorySelectMediaAdapter$ContentItemProvider$convert$1, new Function3<xi.c, SearchMediaItemModel, f, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentItemProvider$convert$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(xi.c cVar, SearchMediaItemModel searchMediaItemModel, f fVar) {
                    invoke2(cVar, searchMediaItemModel, fVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(xi.c cast, SearchMediaItemModel data, f map) {
                    Drawable W0;
                    int U0;
                    int U02;
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    PicPayLoad picPayLoad = (PicPayLoad) map.a(PicPayLoad.class);
                    if (picPayLoad != null) {
                        ImageView imageView2 = imageView;
                        ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter2 = chatHistorySelectMediaAdapter;
                        com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaAdapter", data.j() + " download " + picPayLoad);
                        long j3 = picPayLoad.getNotifyInfo().fileErrCode;
                        if (j3 == 0) {
                            String str = picPayLoad.getNotifyInfo().filePath;
                            Intrinsics.checkNotNullExpressionValue(str, "picPayLoad.notifyInfo.filePath");
                            U0 = chatHistorySelectMediaAdapter2.U0();
                            U02 = chatHistorySelectMediaAdapter2.U0();
                            e.c(imageView2, str, U0, U02);
                        } else {
                            boolean z16 = true;
                            if (j3 != 2006014 && j3 != 2006016) {
                                z16 = false;
                            }
                            if (!z16) {
                                W0 = chatHistorySelectMediaAdapter2.W0();
                                imageView2.setImageDrawable(W0);
                            }
                        }
                    }
                    if (((MultiPayLoad) map.a(MultiPayLoad.class)) != null) {
                        chatHistorySelectMediaAdapter.R0(qUICheckBox, data.j());
                    }
                }
            });
        }

        public final Function1<DownLoadParam, Unit> o() {
            return this.sendIntent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R2\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter$ContentVideoItemProvider;", "Lxi/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "helper", "Lwi/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lyi/a;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "o", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "", "f", "()I", "itemViewType", "<init>", "(Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter;Lkotlin/jvm/functions/Function1;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class ContentVideoItemProvider extends xi.c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final Function1<DownLoadParam, Unit> sendIntent;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatHistorySelectMediaAdapter f56909d;

        /* JADX WARN: Multi-variable type inference failed */
        public ContentVideoItemProvider(ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter, Function1<? super DownLoadParam, Unit> sendIntent) {
            Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
            this.f56909d = chatHistorySelectMediaAdapter;
            this.sendIntent = sendIntent;
        }

        @Override // xi.a
        public View c(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f127821p, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026r_item_media_video, null)");
            return inflate;
        }

        @Override // xi.a
        public int f() {
            return 2;
        }

        @Override // xi.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(a helper, wi.b item, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            final ImageView imageView = (ImageView) helper.getView(R.id.lvd);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.mhy);
            qUICheckBox.setType(3);
            qUICheckBox.setClickable(false);
            ChatHistorySelectMediaAdapter$ContentVideoItemProvider$convert$1 chatHistorySelectMediaAdapter$ContentVideoItemProvider$convert$1 = new ChatHistorySelectMediaAdapter$ContentVideoItemProvider$convert$1(this.f56909d, imageView, helper, qUICheckBox, this, (TextView) helper.getView(R.id.f162968nl3));
            final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter = this.f56909d;
            com.qzone.reborn.groupalbum.selectmedia.util.b.a(this, item, payloads, chatHistorySelectMediaAdapter$ContentVideoItemProvider$convert$1, new Function3<xi.c, SearchMediaItemModel, f, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentVideoItemProvider$convert$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(xi.c cVar, SearchMediaItemModel searchMediaItemModel, f fVar) {
                    invoke2(cVar, searchMediaItemModel, fVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(xi.c cast, SearchMediaItemModel data, f map) {
                    int U0;
                    int U02;
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    PicPayLoad picPayLoad = (PicPayLoad) map.a(PicPayLoad.class);
                    if (picPayLoad != null) {
                        ImageView imageView2 = imageView;
                        ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter2 = chatHistorySelectMediaAdapter;
                        com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaAdapter", data.j() + " video download  " + picPayLoad);
                        long j3 = picPayLoad.getNotifyInfo().fileErrCode;
                        if (j3 == 0) {
                            String str = picPayLoad.getNotifyInfo().filePath;
                            Intrinsics.checkNotNullExpressionValue(str, "picPayLoad.notifyInfo.filePath");
                            U0 = chatHistorySelectMediaAdapter2.U0();
                            U02 = chatHistorySelectMediaAdapter2.U0();
                            e.c(imageView2, str, U0, U02);
                        } else {
                            boolean z16 = true;
                            if (j3 != 2006014 && j3 != 2006016) {
                                z16 = false;
                            }
                            if (!z16) {
                                imageView2.setImageResource(R.drawable.aio_image_fail);
                            }
                        }
                    }
                    if (((MultiPayLoad) map.a(MultiPayLoad.class)) != null) {
                        chatHistorySelectMediaAdapter.R0(qUICheckBox, data.j());
                    }
                }
            });
        }

        public final Function1<DownLoadParam, Unit> o() {
            return this.sendIntent;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatHistorySelectMediaAdapter(int i3, Function1<? super DownLoadParam, Unit> sendIntent, Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState) {
        super(null, 1, null);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        this.source = i3;
        this.setBottomBarState = setBottomBarState;
        this.I = new i();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ColorDrawable>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$defaultDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorDrawable invoke() {
                return new ColorDrawable(BaseApplication.getContext().getColorStateList(R.color.qui_common_overlay_light).getDefaultColor());
            }
        });
        this.defaultDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Drawable>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$failedDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.aio_image_fail);
            }
        });
        this.failedDrawable = lazy2;
        B0(new d());
        B0(new k());
        k0(new ContentItemProvider(this, sendIntent));
        k0(new ContentVideoItemProvider(this, sendIntent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(ImageView imageView) {
        imageView.setImageDrawable(V0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int U0() {
        return g.f56961a.a() / 4;
    }

    private final ColorDrawable V0() {
        return (ColorDrawable) this.defaultDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable W0() {
        return (Drawable) this.failedDrawable.getValue();
    }

    public boolean R0(QUICheckBox cb5, long msgId) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return this.I.d(cb5, msgId);
    }

    public boolean S0(Function1<? super Boolean, Unit> callBack) {
        return this.I.e(callBack);
    }

    public final SearchMediaItemModel X0() {
        Object last;
        Object lastOrNull;
        CopyOnWriteArrayList<wi.b> m06 = m0();
        if (m06 == null || m06.isEmpty()) {
            return null;
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
        wi.b bVar = (wi.b) last;
        if (!(bVar instanceof SearchMediaItemModel)) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) bVar.b());
            if (lastOrNull instanceof SearchMediaItemModel) {
                return (SearchMediaItemModel) lastOrNull;
            }
            return null;
        }
        return (SearchMediaItemModel) bVar;
    }

    public final SearchMediaModel Y0() {
        Object last;
        CopyOnWriteArrayList<wi.b> m06 = m0();
        if (m06 == null || m06.isEmpty()) {
            return null;
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
        wi.b bVar = (wi.b) last;
        if (bVar instanceof SearchMediaModel) {
            return (SearchMediaModel) bVar;
        }
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel");
        zi.a d16 = ((SearchMediaItemModel) bVar).d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaModel");
        return (SearchMediaModel) d16;
    }

    public List<MsgRecord> Z0() {
        return this.I.h();
    }

    public final Function2<Boolean, Boolean, Unit> a1() {
        return this.setBottomBarState;
    }

    public void b1(View itemView, MsgRecord msgRecord, zi.b msgItemModel, QUICheckBox checkbox, Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "msgItemModel");
        Intrinsics.checkNotNullParameter(checkbox, "checkbox");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.I.k(itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener);
    }

    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    protected int o0(List<? extends wi.b> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        wi.b bVar = data.get(position);
        if (bVar instanceof SearchMediaModel) {
            return 0;
        }
        if (bVar instanceof zi.d) {
            return 10;
        }
        if (bVar instanceof SearchMediaItemModel) {
            SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) bVar;
            if (searchMediaItemModel.p()) {
                return 1;
            }
            if (searchMediaItemModel.r()) {
                return 2;
            }
            throw new HistoryException("illegal data " + bVar);
        }
        throw new HistoryException("illegal data " + bVar);
    }
}
