package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper;
import com.tencent.mobileqq.emoticonview.ai.emoticon.EnumSerializer;
import com.tencent.mobileqq.emoticonview.ai.emoticon.PicModel;
import com.tencent.mobileqq.emoticonview.ai.emoticon.album.AiEmoticonAlbumUtils;
import com.tencent.mobileqq.emoticonview.api.IAiEmoticonService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/impl/AiEmoticonServiceImpl;", "Lcom/tencent/mobileqq/emoticonview/api/IAiEmoticonService;", "()V", "getAiEmoticonAlbumIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "maxMediaSize", "", IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK, "Leipc/EIPCResult;", "filePath", "", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AiEmoticonServiceImpl implements IAiEmoticonService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AiEmoticonServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/impl/AiEmoticonServiceImpl$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AiEmoticonServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IAiEmoticonService
    @Nullable
    public Intent getAiEmoticonAlbumIntent(@NotNull Context context, int maxMediaSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, maxMediaSize);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return AiEmoticonAlbumUtils.INSTANCE.getAiEmoticonAlbumIntent(context, maxMediaSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.api.IAiEmoticonService
    @NotNull
    public EIPCResult uploadPicAndCheck(@NotNull String filePath) {
        List listOf;
        int collectionSizeOrDefault;
        Integer num;
        List list;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        QLog.i(TAG, 1, "uploadPicAndCheck  filePath:" + filePath);
        String picThumbPath = AiEmoticonUploadHelper.INSTANCE.getPicThumbPath(filePath);
        String b16 = com.tencent.qqnt.util.file.b.f362981a.b(picThumbPath);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(picThumbPath, b16));
        List list2 = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                break;
            }
            arrayList.add(new PicModel((String) ((Pair) it.next()).getFirst(), null, 2, null));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new AiEmoticonServiceImpl$uploadPicAndCheck$1(objectRef, listOf, list, null), 1, null);
        Bundle bundle = new Bundle();
        CheckImageResult checkImageResult = (CheckImageResult) objectRef.element;
        if (checkImageResult != null) {
            num = Integer.valueOf(checkImageResult.code);
        }
        QLog.i(TAG, 1, "uploadPicAndCheck  checkResultCode:" + num + "  md5:" + b16);
        T t16 = objectRef.element;
        int i3 = -102;
        if (t16 == 0) {
            bundle.putInt("ai_emoticon_toast_res", com.tencent.mobileqq.R.string.yoc);
        } else {
            CheckImageResult checkImageResult2 = (CheckImageResult) t16;
            if (checkImageResult2 != null && checkImageResult2.code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                bundle.putInt("ai_emoticon_toast_res", com.tencent.mobileqq.R.string.yod);
            } else {
                Gson create = new GsonBuilder().registerTypeHierarchyAdapter(Enum.class, new EnumSerializer()).create();
                String json = create.toJson(objectRef.element);
                String json2 = create.toJson(list);
                bundle.putString("ai_emoticon_choose_pic_result", json);
                bundle.putString("ai_emoticon_choose_pic_path", json2);
                QLog.i(TAG, 1, "uploadPicAndCheck  checkImageResultJsonString:" + json + ", picModelJsonString:" + json2);
                i3 = 0;
            }
        }
        EIPCResult createResult = EIPCResult.createResult(i3, bundle);
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(code, bundle)");
        return createResult;
    }
}
