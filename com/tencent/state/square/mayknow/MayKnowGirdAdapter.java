package com.tencent.state.square.mayknow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.state.data.Gender;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareMaybeKnowFriendItemBinding;
import com.tencent.state.square.mayknow.MayKnowGirdAdapter;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.view.MayKnowAvatarImageView;
import com.tencent.state.view.SquareMayKnowLabelView;
import com.tencent.state.view.SquareTabLayout;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J*\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0014\u0010\u0013\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u0000H\u0016J\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowGirdAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/mayknow/MayKnowGirdAdapter$ViewHolder;", "()V", "dataList", "", "Lcom/tencent/state/square/mayknow/MayKnowUser;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "setData", "list", "updateAddFriendStatus", "uin", "", "Companion", "ViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowGirdAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int PAYLOAD_ADD_STATUS_CHANGE = 999;
    private static final String TAG = "MayKnowGirdAdapter";
    private final List<MayKnowUser> dataList = new ArrayList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020\u00120\"H\u0002J,\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010 2\b\u0010)\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010+\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u00101\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowGirdAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/image/URLDrawable$DownloadListener;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareMaybeKnowFriendItemBinding;", "(Lcom/tencent/state/square/mayknow/MayKnowGirdAdapter;Lcom/tencent/state/square/databinding/VasSquareMaybeKnowFriendItemBinding;)V", "avatarDrawable", "Lcom/tencent/image/URLDrawable;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareMaybeKnowFriendItemBinding;", "data", "Lcom/tencent/state/square/mayknow/MayKnowUser;", "reporter", "Lcom/tencent/state/square/IReporter;", "bindAvatarView", "", "bindButton", "bindGenderAndAge", "bindReport", "clearAvatar", "doBindView", "payloads", "", "", "doCheckAndSetRegionAvatar", "", "urlDrawable", "getRegionBitmap", "path", "", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onDecodeTaskCompleted", "remainingTasks", "", "type", "uin", "avatar", "onFileDownloadFailed", "p0", "onFileDownloadStarted", "onFileDownloadSucceed", "", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "setQQAvatar", "startDownloadAndSetAvatar", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder implements URLDrawable.DownloadListener, IDecodeTaskCompletionListener {
        private URLDrawable avatarDrawable;
        private IFaceDecoder avatarFaceDecoder;
        private final VasSquareMaybeKnowFriendItemBinding binding;
        private MayKnowUser data;
        private final IReporter reporter;
        final /* synthetic */ MayKnowGirdAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MayKnowGirdAdapter mayKnowGirdAdapter, VasSquareMaybeKnowFriendItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = mayKnowGirdAdapter;
            this.binding = binding;
            Square square = Square.INSTANCE;
            this.reporter = square.getConfig().getReporter();
            IFaceDecoder faceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
            this.avatarFaceDecoder = faceDecoder;
            faceDecoder.setDecodeTaskCompletionListener(this);
        }

        private final void bindAvatarView(MayKnowUser data) {
            if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, data.getAvatar(), false, 2, null)) {
                MayKnowAvatarImageView mayKnowAvatarImageView = this.binding.mayKnowCardAvatar;
                Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView, "binding.mayKnowCardAvatar");
                mayKnowAvatarImageView.setTag(data.getAvatar());
                URLDrawable drawable = URLDrawable.getDrawable(data.getAvatar(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
                this.avatarDrawable = drawable;
                if (doCheckAndSetRegionAvatar(drawable)) {
                    return;
                }
                startDownloadAndSetAvatar(drawable, data);
            }
        }

        private final void bindButton(MayKnowUser data) {
            if (data.getIsAdd()) {
                Button button = this.binding.mayKnowButton;
                Intrinsics.checkNotNullExpressionValue(button, "binding.mayKnowButton");
                button.setText("\u5f85\u9a8c\u8bc1");
                this.binding.mayKnowButton.setBackgroundResource(R.drawable.guk);
                Button button2 = this.binding.mayKnowButton;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.mayKnowButton");
                button2.setEnabled(false);
                return;
            }
            Button button3 = this.binding.mayKnowButton;
            Intrinsics.checkNotNullExpressionValue(button3, "binding.mayKnowButton");
            button3.setText("\u52a0Q\u53cb");
            this.binding.mayKnowButton.setBackgroundResource(R.drawable.guf);
            Button button4 = this.binding.mayKnowButton;
            Intrinsics.checkNotNullExpressionValue(button4, "binding.mayKnowButton");
            button4.setEnabled(true);
        }

        private final void bindGenderAndAge(MayKnowUser data) {
            Integer valueOf;
            boolean isBlank;
            Integer age;
            Integer gender = data.getGender();
            int ordinal = Gender.MALE.ordinal();
            String str = null;
            if (gender != null && gender.intValue() == ordinal) {
                valueOf = Integer.valueOf(R.drawable.f159813ia2);
            } else {
                valueOf = (gender != null && gender.intValue() == Gender.FEMALE.ordinal()) ? Integer.valueOf(R.drawable.i9o) : null;
            }
            SquareTabLayout tabLayout = this.binding.mayKnowLabelsContainer;
            tabLayout.removeAllViews();
            if (data.getAge() != null && ((age = data.getAge()) == null || age.intValue() != 0)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(data.getAge());
                sb5.append('\u5c81');
                str = sb5.toString();
            }
            if (valueOf != null && str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
                    Context context = tabLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "tabLayout.context");
                    SquareMayKnowLabelView squareMayKnowLabelView = new SquareMayKnowLabelView(context);
                    squareMayKnowLabelView.updateView(str, valueOf, ViewExtensionsKt.dip(squareMayKnowLabelView.getContext(), 2));
                    Unit unit = Unit.INSTANCE;
                    tabLayout.addView(squareMayKnowLabelView);
                }
            }
            for (MayKnowLabel mayKnowLabel : data.getLabels()) {
                Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
                Context context2 = tabLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "tabLayout.context");
                SquareMayKnowLabelView squareMayKnowLabelView2 = new SquareMayKnowLabelView(context2);
                SquareMayKnowLabelView.updateView$default(squareMayKnowLabelView2, mayKnowLabel.getName(), null, ViewExtensionsKt.dip(squareMayKnowLabelView2.getContext(), 2), 2, null);
                Unit unit2 = Unit.INSTANCE;
                tabLayout.addView(squareMayKnowLabelView2);
            }
        }

        private final void getRegionBitmap(final String path, final Function1<? super Bitmap, Unit> callback) {
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$getRegionBitmap$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    File file = new File(path);
                    if (!file.exists()) {
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$getRegionBitmap$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                callback.invoke(null);
                            }
                        });
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(new FileInputStream(file), null, options);
                    int i3 = options.outWidth;
                    int i16 = options.outHeight;
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(path, false);
                    double d16 = i16;
                    int i17 = (int) (0.36d * d16);
                    int i18 = (i3 - ((int) ((i17 - r3) * 1.05f))) / 2;
                    Rect rect = new Rect(i18, (int) (d16 * 0.011d), i3 - i18, i17);
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    final Bitmap decodeRegion = newInstance.decodeRegion(rect, options2);
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$getRegionBitmap$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            callback.invoke(decodeRegion);
                        }
                    });
                }
            });
        }

        private final void setAvatar(MayKnowUser data) {
            bindAvatarView(data);
        }

        private final void setQQAvatar(MayKnowUser data) {
            Bitmap bitmapFromCache$default = IFaceDecoder.DefaultImpls.getBitmapFromCache$default(this.avatarFaceDecoder, String.valueOf(data.getUin()), false, 2, null);
            if (bitmapFromCache$default != null) {
                this.binding.mayKnowQqAvatar.setImageBitmap(bitmapFromCache$default);
            } else {
                IFaceDecoder.DefaultImpls.requestDecodeFace$default(this.avatarFaceDecoder, String.valueOf(data.getUin()), false, 2, null);
                this.binding.mayKnowQqAvatar.setImageResource(R.drawable.i9d);
            }
        }

        public final void bindReport(MayKnowUser data) {
            Intrinsics.checkNotNullParameter(data, "data");
            IReporter iReporter = this.reporter;
            RelativeLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            iReporter.setElementInfo(root, SquareReportConst.ElementId.ELEMENT_ID_MAY_KNOW_CARD, new LinkedHashMap(), false, false);
            VideoReport.setElementReuseIdentifier(this.binding.getRoot(), "em_may_know_people_card_" + data.getUin());
            this.reporter.reportEvent("imp", new LinkedHashMap());
            IReporter iReporter2 = this.reporter;
            Button button = this.binding.mayKnowButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.mayKnowButton");
            iReporter2.setElementInfo(button, SquareReportConst.ElementId.ELEMENT_ID_MAY_KNOW_CARD_BUTTON, new LinkedHashMap(), false, false);
            VideoReport.setElementReuseIdentifier(this.binding.mayKnowButton, "em_may_know_people_add_btn_" + data.getUin());
            this.reporter.reportEvent("imp", new LinkedHashMap());
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void doBindView(final MayKnowUser data) {
            boolean z16;
            String nick;
            boolean isBlank;
            boolean isBlank2;
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            String mayKnowReason = data.getMayKnowReason();
            boolean z17 = true;
            if (mayKnowReason != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(mayKnowReason);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        TextView textView = this.binding.mayKnowReason;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.mayKnowReason");
                        textView.setVisibility(8);
                    } else {
                        TextView textView2 = this.binding.mayKnowReason;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.mayKnowReason");
                        textView2.setText(data.getMayKnowReason());
                        TextView textView3 = this.binding.mayKnowReason;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.mayKnowReason");
                        textView3.setVisibility(0);
                    }
                    setAvatar(data);
                    setQQAvatar(data);
                    nick = data.getNick();
                    if (nick != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(nick);
                        if (!isBlank) {
                            z17 = false;
                        }
                    }
                    if (!z17) {
                        TextView textView4 = this.binding.mayKnowNick;
                        Intrinsics.checkNotNullExpressionValue(textView4, "binding.mayKnowNick");
                        textView4.setText(String.valueOf(data.getUin()));
                    } else {
                        TextView textView5 = this.binding.mayKnowNick;
                        Intrinsics.checkNotNullExpressionValue(textView5, "binding.mayKnowNick");
                        textView5.setText(data.getNick());
                    }
                    bindGenderAndAge(data);
                    this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$doBindView$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                            IReporter iReporter;
                            IRouter router = Square.INSTANCE.getConfig().getRouter();
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            Context context = it.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "it.context");
                            String valueOf = String.valueOf(data.getUin());
                            String nick2 = data.getNick();
                            if (nick2 == null) {
                                nick2 = String.valueOf(data.getUin());
                            }
                            router.routeToFriendProfileCard(context, valueOf, nick2, data.getMayKnowReason());
                            iReporter = MayKnowGirdAdapter.ViewHolder.this.reporter;
                            RelativeLayout root = MayKnowGirdAdapter.ViewHolder.this.getBinding().getRoot();
                            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                            iReporter.reportEvent("clck", root, new LinkedHashMap());
                        }
                    });
                    bindButton(data);
                    this.binding.mayKnowButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$doBindView$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            IReporter iReporter;
                            if (view != null) {
                                Button button = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowButton;
                                Intrinsics.checkNotNullExpressionValue(button, "binding.mayKnowButton");
                                if (button.isEnabled()) {
                                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                                    Context context = view.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                                    String valueOf = String.valueOf(data.getUin());
                                    String nick2 = data.getNick();
                                    if (nick2 == null) {
                                        nick2 = "";
                                    }
                                    router.routeToAddFriend(context, valueOf, nick2);
                                }
                                iReporter = MayKnowGirdAdapter.ViewHolder.this.reporter;
                                Button button2 = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowButton;
                                Intrinsics.checkNotNullExpressionValue(button2, "binding.mayKnowButton");
                                iReporter.reportEvent("clck", button2, new LinkedHashMap());
                            }
                        }
                    });
                }
            }
            z16 = true;
            if (!z16) {
            }
            setAvatar(data);
            setQQAvatar(data);
            nick = data.getNick();
            if (nick != null) {
            }
            if (!z17) {
            }
            bindGenderAndAge(data);
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$doBindView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    IReporter iReporter;
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Context context = it.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    String valueOf = String.valueOf(data.getUin());
                    String nick2 = data.getNick();
                    if (nick2 == null) {
                        nick2 = String.valueOf(data.getUin());
                    }
                    router.routeToFriendProfileCard(context, valueOf, nick2, data.getMayKnowReason());
                    iReporter = MayKnowGirdAdapter.ViewHolder.this.reporter;
                    RelativeLayout root = MayKnowGirdAdapter.ViewHolder.this.getBinding().getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    iReporter.reportEvent("clck", root, new LinkedHashMap());
                }
            });
            bindButton(data);
            this.binding.mayKnowButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$doBindView$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IReporter iReporter;
                    if (view != null) {
                        Button button = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowButton;
                        Intrinsics.checkNotNullExpressionValue(button, "binding.mayKnowButton");
                        if (button.isEnabled()) {
                            IRouter router = Square.INSTANCE.getConfig().getRouter();
                            Context context = view.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "it.context");
                            String valueOf = String.valueOf(data.getUin());
                            String nick2 = data.getNick();
                            if (nick2 == null) {
                                nick2 = "";
                            }
                            router.routeToAddFriend(context, valueOf, nick2);
                        }
                        iReporter = MayKnowGirdAdapter.ViewHolder.this.reporter;
                        Button button2 = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowButton;
                        Intrinsics.checkNotNullExpressionValue(button2, "binding.mayKnowButton");
                        iReporter.reportEvent("clck", button2, new LinkedHashMap());
                    }
                }
            });
        }

        public final VasSquareMaybeKnowFriendItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
            MayKnowUser mayKnowUser = this.data;
            if (!TextUtils.equals(String.valueOf(mayKnowUser != null ? Long.valueOf(mayKnowUser.getUin()) : null), uin) || avatar == null) {
                return;
            }
            this.binding.mayKnowQqAvatar.setImageBitmap(avatar);
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long p06) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$onFileDownloadSucceed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    URLDrawable uRLDrawable;
                    MayKnowGirdAdapter.ViewHolder viewHolder = MayKnowGirdAdapter.ViewHolder.this;
                    uRLDrawable = viewHolder.avatarDrawable;
                    viewHolder.doCheckAndSetRegionAvatar(uRLDrawable);
                }
            });
        }

        public final void clearAvatar() {
            this.data = null;
            this.avatarDrawable = null;
            MayKnowAvatarImageView mayKnowAvatarImageView = this.binding.mayKnowCardAvatar;
            Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView, "binding.mayKnowCardAvatar");
            mayKnowAvatarImageView.setTag(null);
            this.binding.mayKnowCardAvatar.setImageBitmap(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean doCheckAndSetRegionAvatar(final URLDrawable urlDrawable) {
            URL url;
            String url2;
            if (urlDrawable == null || (url = urlDrawable.getURL()) == null || (url2 = url.toString()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(url2, "urlDrawable?.url?.toString() ?: return false");
            File urlDrawableFile = Square.INSTANCE.getConfig().getCommonUtils().getUrlDrawableFile(url2);
            if (urlDrawableFile == null) {
                urlDrawableFile = urlDrawable.getFileInLocal();
            }
            if (urlDrawableFile == null || !urlDrawableFile.exists()) {
                return false;
            }
            String absolutePath = urlDrawableFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            getRegionBitmap(absolutePath, new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.mayknow.MayKnowGirdAdapter$ViewHolder$doCheckAndSetRegionAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Bitmap bitmap) {
                    MayKnowAvatarImageView mayKnowAvatarImageView = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowCardAvatar;
                    Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView, "binding.mayKnowCardAvatar");
                    if (mayKnowAvatarImageView.getTag() != null) {
                        MayKnowAvatarImageView mayKnowAvatarImageView2 = MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowCardAvatar;
                        Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView2, "binding.mayKnowCardAvatar");
                        if (Intrinsics.areEqual(mayKnowAvatarImageView2.getTag().toString(), urlDrawable.getURL().toString())) {
                            MayKnowGirdAdapter.ViewHolder.this.getBinding().mayKnowCardAvatar.setImageBitmap(bitmap);
                        }
                    }
                }
            });
            MayKnowAvatarImageView mayKnowAvatarImageView = this.binding.mayKnowCardAvatar;
            Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView, "binding.mayKnowCardAvatar");
            if (mayKnowAvatarImageView.getTag() == null) {
                return false;
            }
            MayKnowAvatarImageView mayKnowAvatarImageView2 = this.binding.mayKnowCardAvatar;
            Intrinsics.checkNotNullExpressionValue(mayKnowAvatarImageView2, "binding.mayKnowCardAvatar");
            return Intrinsics.areEqual(mayKnowAvatarImageView2.getTag().toString(), urlDrawable.getURL().toString());
        }

        private final void startDownloadAndSetAvatar(URLDrawable urlDrawable, MayKnowUser data) {
            if (urlDrawable != null) {
                urlDrawable.startDownload(false);
            }
            if (urlDrawable != null) {
                urlDrawable.setDownloadListener(this);
            }
            Integer gender = data.getGender();
            this.binding.mayKnowCardAvatar.setImageResource((gender != null && gender.intValue() == Gender.FEMALE.ordinal()) ? R.drawable.f159814ia3 : R.drawable.f159815ia4);
        }

        public final void doBindView(MayKnowUser data, List<Object> payloads) {
            Object first;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.data = data;
            if (!payloads.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) payloads);
                if (Intrinsics.areEqual(first, (Object) 999)) {
                    bindButton(data);
                }
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int p06) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final void setData(List<MayKnowUser> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    public final void updateAddFriendStatus(String uin) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(String.valueOf(((MayKnowUser) obj).getUin()), uin)) {
                    break;
                }
            }
        }
        MayKnowUser mayKnowUser = (MayKnowUser) obj;
        if (mayKnowUser != null) {
            mayKnowUser.setAdd(true);
            notifyItemChanged(this.dataList.indexOf(mayKnowUser), 999);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i3, List list) {
        onBindViewHolder2(viewHolder, i3, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareMaybeKnowFriendItemBinding inflate = VasSquareMaybeKnowFriendItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMaybeKnowFriend\u2026ter.from(parent.context))");
        return new ViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.clearAvatar();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        MayKnowUser mayKnowUser = (MayKnowUser) orNull;
        if (mayKnowUser != null) {
            holder.doBindView(mayKnowUser);
            holder.bindReport(mayKnowUser);
        }
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(ViewHolder holder, int position, List<Object> payloads) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
            MayKnowUser mayKnowUser = (MayKnowUser) orNull;
            if (mayKnowUser != null) {
                holder.doBindView(mayKnowUser, payloads);
                return;
            }
            return;
        }
        super.onBindViewHolder((MayKnowGirdAdapter) holder, position, payloads);
    }
}
