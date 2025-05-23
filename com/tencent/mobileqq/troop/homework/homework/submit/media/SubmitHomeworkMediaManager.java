package com.tencent.mobileqq.troop.homework.homework.submit.media;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWImgCompressHelper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR8\u0010\"\u001a&\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d \u001e*\u0012\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010\u001f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/media/SubmitHomeworkMediaManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/PublishMediaEditManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c0", "", "items", "e0", "G", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", "d0", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", "dataModel", "", BdhLogUtil.LogTag.Tag_Req, "I", "g", "()I", "audioNumLimit", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "L", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "imgQuality", "", "", "kotlin.jvm.PlatformType", "", "T", "Ljava/util/Set;", "downloadAudioTaskSet", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;)V", "U", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class SubmitHomeworkMediaManager extends PublishMediaEditManager {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final e dataModel;

    /* renamed from: R, reason: from kotlin metadata */
    private final int audioNumLimit;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final HWImgCompressHelper.ImgQuality imgQuality;

    /* renamed from: T, reason: from kotlin metadata */
    private final Set<String> downloadAudioTaskSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/media/SubmitHomeworkMediaManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.media.SubmitHomeworkMediaManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitHomeworkMediaManager(@NotNull String troopUin, @NotNull CoroutineScope scope) {
        super(troopUin, scope, 0, 4, null);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin, (Object) scope);
            return;
        }
        e eVar = new e();
        eVar.k().setMaxWordCount(2500);
        this.dataModel = eVar;
        this.audioNumLimit = 6;
        this.imgQuality = HWImgCompressHelper.ImgQuality.STANDARD;
        this.downloadAudioTaskSet = Collections.synchronizedSet(new HashSet());
    }

    private final void c0(BaseItem item) {
        boolean z16;
        String httpUrl = item.getHttpUrl();
        if (httpUrl == null) {
            return;
        }
        if (httpUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (!this.downloadAudioTaskSet.contains(httpUrl)) {
            BuildersKt__Builders_commonKt.launch$default(M(), Dispatchers.getIO(), null, new SubmitHomeworkMediaManager$downloadAudioItem$1(item, this, httpUrl, null), 2, null);
        } else {
            QLog.i("SubmitHWHWDetailMediaDataModel", 1, "downloadAudioFile, but downloadTaskSet contains it.");
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.G();
            this.downloadAudioTaskSet.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    @NotNull
    public HWImgCompressHelper.ImgQuality L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HWImgCompressHelper.ImgQuality) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.imgQuality;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    @NotNull
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    public final void e0(@Nullable List<? extends BaseItem> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) items);
            return;
        }
        if (items != null) {
            Iterator<? extends BaseItem> it = items.iterator();
            while (it.hasNext()) {
                c0(it.next());
            }
            K().t(items);
        }
        Q();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.audioNumLimit;
    }
}
