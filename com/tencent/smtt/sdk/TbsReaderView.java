package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";

    /* renamed from: f, reason: collision with root package name */
    static boolean f369168f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* renamed from: a, reason: collision with root package name */
    Context f369169a;

    /* renamed from: b, reason: collision with root package name */
    f f369170b;

    /* renamed from: c, reason: collision with root package name */
    Object f369171c;

    /* renamed from: d, reason: collision with root package name */
    ReaderCallback f369172d;

    /* renamed from: e, reason: collision with root package name */
    ReaderCallback f369173e;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(context.getApplicationContext());
        this.f369169a = null;
        this.f369170b = null;
        this.f369171c = null;
        this.f369172d = null;
        this.f369173e = null;
        if (context instanceof Activity) {
            this.f369172d = readerCallback;
            this.f369169a = context;
            this.f369173e = new ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
                /* JADX WARN: Removed duplicated region for block: B:14:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0190 A[ADDED_TO_REGION] */
                @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onCallBackAction(Integer num, Object obj, Object obj2) {
                    Bundle bundle;
                    ReaderCallback readerCallback2;
                    int intValue = num.intValue();
                    String str = "";
                    Bundle bundle2 = null;
                    boolean z16 = true;
                    if (intValue != 5026) {
                        if (intValue != 5030) {
                            switch (intValue) {
                                case 5008:
                                    if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f369169a)) {
                                        num = 5011;
                                        String resString = TbsReaderView.getResString(TbsReaderView.this.f369169a, 5023);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG);
                                        obj = bundle;
                                        break;
                                    } else {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f369169a, str, 4, 0, FileReaderHelper.PDF_EXT, bundle2);
                                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER);
                                        break;
                                    }
                                case 5009:
                                    if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f369169a)) {
                                        num = 5011;
                                        String resString2 = TbsReaderView.getResString(TbsReaderView.this.f369169a, 5021);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString2);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG);
                                        obj = bundle;
                                        break;
                                    } else {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f369169a, str, 4, 0, "", bundle2);
                                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER);
                                        break;
                                    }
                                case 5010:
                                    if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f369169a)) {
                                        num = 5011;
                                        String resString3 = TbsReaderView.getResString(TbsReaderView.this.f369169a, 5022);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString3);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG);
                                        obj = bundle;
                                        break;
                                    } else {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f369169a, str, 4, 0, FileReaderHelper.TXT_EXT, bundle2);
                                        break;
                                    }
                            }
                        } else if (obj != null) {
                            Bundle bundle3 = (Bundle) obj;
                            TbsReaderView.gReaderPackName = bundle3.getString("name");
                            TbsReaderView.gReaderPackVersion = bundle3.getString("version");
                        }
                        readerCallback2 = TbsReaderView.this.f369172d;
                        if (readerCallback2 != null && !z16) {
                            readerCallback2.onCallBackAction(num, obj, obj2);
                            return;
                        }
                        return;
                    }
                    if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f369169a)) {
                        num = 5011;
                        String resString4 = TbsReaderView.getResString(TbsReaderView.this.f369169a, 5029);
                        bundle = new Bundle();
                        bundle.putString("tip", resString4);
                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG);
                        obj = bundle;
                    } else {
                        if (obj != null) {
                            bundle2 = (Bundle) obj;
                            str = bundle2.getString("docpath");
                        }
                        QbSdk.startQBForDoc(TbsReaderView.this.f369169a, str, 4, 0, FileReaderHelper.DOC_EXT, bundle2);
                        TbsReaderView.this.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER);
                        readerCallback2 = TbsReaderView.this.f369172d;
                        if (readerCallback2 != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    z16 = false;
                    readerCallback2 = TbsReaderView.this.f369172d;
                    if (readerCallback2 != null) {
                    }
                }
            };
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        if (!f369168f) {
            g.a(true).a(context.getApplicationContext(), true, false);
            f369168f = g.a(false).b();
        }
        return f369168f;
    }

    public static Drawable getResDrawable(Context context, int i3) {
        if (a(context)) {
            return f.a(i3);
        }
        return null;
    }

    public static String getResString(Context context, int i3) {
        if (a(context)) {
            return f.b(i3);
        }
        return "";
    }

    public static boolean isSupportExt(Context context, String str) {
        if (!a(context) || !f.a(context) || !f.a(str)) {
            return false;
        }
        return true;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        f fVar = this.f369170b;
        if (fVar != null && (obj3 = this.f369171c) != null) {
            fVar.a(obj3, num, obj, obj2);
        }
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f369171c;
        if (obj == null) {
            Log.e("TbsReaderView", "downloadPlugin failed!");
            return false;
        }
        return this.f369170b.a(obj, this.f369169a, str, true);
    }

    public void onSizeChanged(int i3, int i16) {
        Object obj;
        f fVar = this.f369170b;
        if (fVar != null && (obj = this.f369171c) != null) {
            fVar.a(obj, i3, i16);
        }
    }

    public void onStop() {
        f fVar = this.f369170b;
        if (fVar != null) {
            fVar.a(this.f369171c);
            this.f369171c = null;
        }
        this.f369169a = null;
        f369168f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f369171c != null && bundle != null) {
            bundle.putBoolean("browser6.0", MttLoader.isBrowserInstalledEx(this.f369169a) | (!MttLoader.isBrowserInstalled(this.f369169a)));
            bundle.putBoolean("browser6.1", MttLoader.isGreatBrowserVer(this.f369169a, 6101625L, 610000L) | (!MttLoader.isBrowserInstalled(this.f369169a)));
            if (!this.f369170b.a(this.f369171c, this.f369169a, bundle, this)) {
                Log.e("TbsReaderView", "OpenFile failed!");
                return;
            }
            return;
        }
        Log.e("TbsReaderView", "init failed!");
    }

    public boolean preOpen(String str, boolean z16) {
        boolean z17 = false;
        if (!isSupportExt(this.f369169a, str)) {
            Log.e("TbsReaderView", "not supported by:" + str);
            return false;
        }
        boolean a16 = a(this.f369169a);
        if (a16) {
            boolean a17 = a();
            if (z16 && a17) {
                if (Apn.getApnType(this.f369169a) == 3) {
                    z17 = true;
                }
                return this.f369170b.a(this.f369171c, this.f369169a, str, z17);
            }
            return a17;
        }
        return a16;
    }

    public void userStatistics(String str) {
        f fVar = this.f369170b;
        if (fVar != null) {
            fVar.a(this.f369171c, str);
        }
    }

    boolean a() {
        try {
            if (this.f369170b == null) {
                this.f369170b = new f(this.f369173e);
            }
            if (this.f369171c == null) {
                this.f369171c = this.f369170b.a();
            }
            Object obj = this.f369171c;
            if (obj != null) {
                return this.f369170b.a(obj, this.f369169a);
            }
            return false;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderView", "Unexpect null object!");
            return false;
        }
    }
}
