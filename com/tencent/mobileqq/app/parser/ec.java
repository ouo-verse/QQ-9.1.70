package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.graphics.Bitmap;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/parser/ec;", "Lcom/tencent/mobileqq/utils/ax;", "Landroid/content/Context;", "context", "", "H", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ec extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/parser/ec$a;", "", "", "TAG", "Ljava/lang/String;", "TROOP_FILE_SEARCH_TEMP_THUMB_PNG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.parser.ec$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec(@NotNull BaseQQAppInterface app, @NotNull Context context) {
        super(app, context);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) context);
        }
    }

    private final void H(Context context) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        FileOutputStream openFileOutput = context.openFileOutput("troop_file_search_temp_thumb.tmp", 0);
        try {
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, openFileOutput);
            CloseableKt.closeFinally(openFileOutput, null);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00de, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r22);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void I(BaseQQAppInterface baseQQAppInterface, long j3, String str, com.tencent.mobileqq.troop.data.t stateInfo, final ec this$0, String str2, String str3) {
        String str4;
        boolean z16;
        long j16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(stateInfo, "$stateInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopInfo troopInfo = ((ITroopInfoService) baseQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(String.valueOf(j3));
        if (troopInfo != null) {
            String str5 = troopInfo.troopowneruin;
            boolean z17 = false;
            if (str5 != null && str5.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
                com.tencent.mobileqq.troop.data.t H = TroopFileTransferManager.O(qQAppInterface, j3).H(str);
                if (H != null) {
                    String str6 = H.f294978l;
                    stateInfo.f294978l = str6;
                    QLog.i("TroopFileOpenDetailAction", 1, "local has file\uff0clocalFile=" + str6);
                }
                if (FileManagerUtil.getFileType(stateInfo.f294987u) == 0) {
                    String str7 = stateInfo.f294978l;
                    if (str7 == null || str7.length() == 0) {
                        z17 = true;
                    }
                    if (z17 || !new File(stateInfo.f294978l).exists()) {
                        String str8 = this$0.f307437b.getFilesDir().getAbsolutePath() + "/troop_file_search_temp_thumb.tmp";
                        if (!new File(str8).exists()) {
                            QLog.i("TroopFileOpenDetailAction", 1, "create thumb, thumbPath=" + str8);
                            Context context = this$0.f307437b;
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            this$0.H(context);
                        } else {
                            QLog.i("TroopFileOpenDetailAction", 1, "thumb file exist");
                        }
                        stateInfo.f294979m = str8;
                    }
                }
                Context context2 = this$0.f307437b;
                if (str3 != null && longOrNull != null) {
                    j16 = longOrNull.longValue();
                } else {
                    j16 = 0;
                }
                QFileUtils.n(qQAppInterface, context2, null, null, j3, stateInfo, str2, j16, 0, 4, null, false, false);
                return;
            }
        }
        if (troopInfo != null) {
            str4 = troopInfo.troopowneruin;
        } else {
            str4 = null;
        }
        QLog.e("TroopFileOpenDetailAction", 1, "groupUin=" + j3 + ", troopInfo=" + troopInfo + ", troopowneruin=" + str4);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.parser.eb
            @Override // java.lang.Runnable
            public final void run() {
                ec.J(ec.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ec this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.f307437b, "\u975e\u7fa4\u6210\u5458\uff0c\u6587\u4ef6\u6253\u5f00\u5931\u8d25", 1).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0141, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0153, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0163, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        long j3;
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        long j16;
        Long longOrNull;
        Integer intOrNull;
        Integer intOrNull2;
        Long longOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String str = this.f307441f.get("groupUin");
        if (str != null && longOrNull2 != null) {
            j3 = longOrNull2.longValue();
        } else {
            j3 = 0;
        }
        final String str2 = this.f307441f.get("fileId");
        String str3 = this.f307441f.get(WadlProxyConsts.PARAM_FILENAME);
        String str4 = this.f307441f.get("busId");
        final String str5 = this.f307441f.get("deadTime");
        String str6 = this.f307441f.get("fileSize");
        String str7 = this.f307441f.get(PhotoCategorySinglePicInfo.UPLOAD_TIME);
        final String str8 = this.f307441f.get("uploaderName");
        QLog.i("TroopFileOpenDetailAction", 1, "schema=" + this.f307438c);
        QLog.i("TroopFileOpenDetailAction", 1, "groupUin=" + j3 + ", fileId=" + str2 + ", fileName=" + str3 + ", busId=" + str4 + ", deadTime=" + str5 + ", fileSize=" + str6 + ", uploadTime=" + str7 + ", uploaderUin=" + str8);
        if (j3 != 0) {
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    final BaseQQAppInterface baseQQAppInterface = this.f307436a;
                    if (!(baseQQAppInterface instanceof QQAppInterface)) {
                        QLog.i("TroopFileOpenDetailAction", 1, "doAction failed, app = " + baseQQAppInterface);
                        return false;
                    }
                    final com.tencent.mobileqq.troop.data.t tVar = new com.tencent.mobileqq.troop.data.t();
                    tVar.f294967a = UUID.randomUUID();
                    tVar.f294971e = j3;
                    tVar.f294987u = str3;
                    if (str4 != null && intOrNull2 != null) {
                        i3 = intOrNull2.intValue();
                    } else {
                        i3 = 0;
                    }
                    tVar.f294988v = i3;
                    tVar.f294985s = str2;
                    if (str7 != null && intOrNull != null) {
                        i16 = intOrNull.intValue();
                    } else {
                        i16 = 0;
                    }
                    tVar.f294975i = i16;
                    if (str6 != null && longOrNull != null) {
                        j16 = longOrNull.longValue();
                    } else {
                        j16 = 0;
                    }
                    tVar.f294976j = j16;
                    final long j17 = j3;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.parser.ea
                        @Override // java.lang.Runnable
                        public final void run() {
                            ec.I(BaseQQAppInterface.this, j17, str2, tVar, this, str8, str5);
                        }
                    }, 16, null, false);
                    return true;
                }
            }
        }
        QQToast.makeText(this.f307437b, "\u6587\u4ef6\u6253\u5f00\u5931\u8d25", 1).show();
        return false;
    }
}
