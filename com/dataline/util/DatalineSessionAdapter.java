package com.dataline.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.h;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.image.URLImageView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.o;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DatalineSessionAdapter extends l {
    protected Context C;
    protected LiteActivity D;
    protected QQAppInterface E;
    private int F;
    private int G;
    private int I;

    /* renamed from: i, reason: collision with root package name */
    private DataLineMsgSetList f32338i;

    /* renamed from: m, reason: collision with root package name */
    protected LayoutInflater f32339m;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f32336f = null;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f32337h = null;
    private boolean H = true;
    protected View.OnClickListener J = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DatalineSessionAdapter.this.p()) {
                DatalineSessionAdapter.this.A();
                h hVar = (h) view.getTag();
                DataLineMsgSet d16 = hVar.d();
                DataLineMsgRecord firstItem = d16.getFirstItem();
                if (firstItem != null) {
                    if (firstItem.fileMsgStatus == 3) {
                        Context context = DatalineSessionAdapter.this.C;
                        QQToast.makeText(context, context.getString(R.string.f1626220x), 0).show();
                    } else if (d16.isSingle()) {
                        if (-1000 != firstItem.msgtype) {
                            FileManagerEntity newEntityByDataLineFileInfo = FileManagerUtil.newEntityByDataLineFileInfo(firstItem);
                            if (firstItem.nOpType == 31 || FileManagerUtil.isTroopFile(newEntityByDataLineFileInfo)) {
                                DatalineSessionAdapter.this.s(firstItem);
                            } else if (firstItem.nOpType == 29) {
                                DatalineSessionAdapter.this.r(firstItem);
                            } else {
                                int i3 = newEntityByDataLineFileInfo.nFileType;
                                if (i3 != 0 && i3 != 2) {
                                    ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(DatalineSessionAdapter.this.C, new com.tencent.mobileqq.filemanager.openbrowser.d(DatalineSessionAdapter.this.E, newEntityByDataLineFileInfo, 3), new com.tencent.mobileqq.filemanager.openbrowser.c().d(11));
                                } else {
                                    DatalineSessionAdapter datalineSessionAdapter = DatalineSessionAdapter.this;
                                    dc1.c cVar = new dc1.c(datalineSessionAdapter.E, datalineSessionAdapter.C, newEntityByDataLineFileInfo);
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    if (newEntityByDataLineFileInfo.nFileType == 0) {
                                        Iterator<DataLineMsgSet> it = DatalineSessionAdapter.this.f32338i.iterator();
                                        while (it.hasNext()) {
                                            DataLineMsgSet next = it.next();
                                            if (next.isSingle()) {
                                                Iterator<DataLineMsgRecord> it5 = next.values().iterator();
                                                while (it5.hasNext()) {
                                                    DataLineMsgRecord next2 = it5.next();
                                                    int fileType = FileManagerUtil.getFileType(next2.filename);
                                                    if (fileType == -1 && next2.msgtype == -2000) {
                                                        fileType = 0;
                                                    }
                                                    if (fileType != newEntityByDataLineFileInfo.nFileType) {
                                                        break;
                                                    } else if (next2 != firstItem) {
                                                        arrayList.add(String.valueOf(FileManagerUtil.newEntityByDataLineFileInfo(next2).nSessionId));
                                                    } else {
                                                        arrayList.add(String.valueOf(newEntityByDataLineFileInfo.nSessionId));
                                                    }
                                                }
                                            }
                                        }
                                        if (arrayList.size() == 0) {
                                            arrayList.add(String.valueOf(newEntityByDataLineFileInfo.nSessionId));
                                        }
                                        cVar.v(arrayList);
                                    }
                                    Rect b06 = QFileUtils.b0(hVar.a().f32394a, newEntityByDataLineFileInfo.fileName);
                                    dc1.d dVar = new dc1.d(DatalineSessionAdapter.this.C, cVar);
                                    dVar.m(11);
                                    dVar.r(b06);
                                    dVar.d();
                                }
                            }
                        }
                    } else if (d16.getGroupType() == -2000) {
                        Intent intent = new Intent(DatalineSessionAdapter.this.D, (Class<?>) LiteMutiPicViewerActivity.class);
                        intent.putExtra("dataline_group_id", d16.getGroupId());
                        DatalineSessionAdapter.this.D.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(DatalineSessionAdapter.this.D, (Class<?>) DLFilesViewerActivity.class);
                        intent2.putExtra("dl_files_groupid", d16.getGroupId());
                        DatalineSessionAdapter.this.D.startActivityForResult(intent2, 102);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            DatalineSessionAdapter datalineSessionAdapter = DatalineSessionAdapter.this;
            FileManagerUtil.enterQlinkFromAio(datalineSessionAdapter.D, datalineSessionAdapter.E.getCurrentAccountUin(), HardCodeUtil.qqStr(R.string.cf5), HardCodeUtil.qqStr(R.string.cf5));
            ReportController.o(DatalineSessionAdapter.this.E, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#00a5e0"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements ah.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataLineMsgRecord f32342a;

        c(DataLineMsgRecord dataLineMsgRecord) {
            this.f32342a = dataLineMsgRecord;
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.f
        public void onClick(View view) {
            ((DataLineMessageSpreadManager) DatalineSessionAdapter.this.E.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).m(this.f32342a, DatalineSessionAdapter.this.C);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d implements ah.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataLineMsgRecord f32344a;

        d(DataLineMsgRecord dataLineMsgRecord) {
            this.f32344a = dataLineMsgRecord;
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.f
        public void onClick(View view) {
            DatalineSessionAdapter datalineSessionAdapter = DatalineSessionAdapter.this;
            if (datalineSessionAdapter.E != null && datalineSessionAdapter.C != null) {
                WeakReference weakReference = new WeakReference(DatalineSessionAdapter.this.C);
                Context context = DatalineSessionAdapter.this.C;
                if (context instanceof Activity) {
                    if (!NetworkUtil.isNetSupport(context)) {
                        QQToast.makeText(DatalineSessionAdapter.this.C, R.string.b3j, 0).show(DatalineSessionAdapter.this.C.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return;
                    }
                    if (this.f32344a != null && weakReference.get() != null) {
                        String extInfoFromExtStr = this.f32344a.getExtInfoFromExtStr(AppConstants.KEY_TEAM_WORK_EXT_INFO_NEW_URL);
                        Boolean.parseBoolean(this.f32344a.getExtInfoFromExtStr("team_work_is_message_convert"));
                        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("url", extInfoFromExtStr);
                            bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_AIO_GREY);
                            TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity((Context) weakReference.get(), bundle, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        public DataLineMsgSet f32346d;

        /* renamed from: e, reason: collision with root package name */
        public h f32347e;

        /* renamed from: f, reason: collision with root package name */
        private int f32348f;

        /* renamed from: h, reason: collision with root package name */
        private int f32349h;

        /* renamed from: i, reason: collision with root package name */
        private AsyncImageView[] f32350i = new AsyncImageView[3];

        e(h hVar, DataLineMsgSet dataLineMsgSet, int i3) {
            this.f32347e = hVar;
            this.f32346d = dataLineMsgSet;
            this.f32348f = i3;
            this.f32349h = i3;
            a();
        }

        private void a() {
            for (int i3 = 0; i3 < 3; i3++) {
                this.f32350i[i3] = new AsyncImageView(DatalineSessionAdapter.this.D);
                this.f32350i[i3].setLayoutParams(new AbsListView.LayoutParams(this.f32348f, this.f32349h));
                this.f32350i[i3].setAdjustViewBounds(false);
                this.f32350i[i3].setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f32350i[i3].setDefaultImage(R.drawable.h7o);
                this.f32350i[i3].setIsDrawRound(false);
                this.f32350i[i3].setAsyncClipSize(this.f32348f, this.f32349h);
                this.f32350i[i3].setTag(this.f32347e);
                this.f32350i[i3].setClickable(true);
                this.f32350i[i3].setLongClickable(true);
                this.f32350i[i3].setOnClickListener(DatalineSessionAdapter.this.J);
                this.f32350i[i3].setOnLongClickListener(DatalineSessionAdapter.this.D.f32039a1);
                this.f32350i[i3].setOnTouchListener(DatalineSessionAdapter.this.D.f32041b1);
                this.f32350i[i3].setContentDescription(HardCodeUtil.qqStr(R.string.l8j));
            }
        }

        public void b() {
            for (int i3 = 0; i3 < 3; i3++) {
                AsyncImageView asyncImageView = this.f32350i[i3];
                asyncImageView.setTag(this.f32347e);
                DataLineMsgRecord at5 = this.f32346d.getAt(i3);
                if (at5 == null) {
                    asyncImageView.setImageResource(R.drawable.h7o);
                } else {
                    String d16 = com.tencent.mobileqq.filemanager.util.l.d(at5.path);
                    if (d16 != null && new VFSFile(d16).exists()) {
                        asyncImageView.setAsyncImage(d16);
                    } else {
                        String str = at5.thumbPath;
                        if (str != null) {
                            asyncImageView.setAsyncImage(str);
                        }
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f32346d.getAt(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            AsyncImageView asyncImageView;
            if (i3 >= 3) {
                asyncImageView = null;
            } else {
                asyncImageView = this.f32350i[i3];
                asyncImageView.setTag(this.f32347e);
                DataLineMsgRecord at5 = this.f32346d.getAt(i3);
                if (at5 == null) {
                    asyncImageView.setImageResource(R.drawable.h7o);
                } else {
                    String d16 = com.tencent.mobileqq.filemanager.util.l.d(at5.path);
                    if (d16 != null && new VFSFile(d16).exists()) {
                        asyncImageView.setAsyncImage(d16);
                    } else {
                        String str = at5.thumbPath;
                        if (str != null) {
                            asyncImageView.setAsyncImage(str);
                        }
                    }
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return asyncImageView;
        }
    }

    public DatalineSessionAdapter(Context context, DataLineMsgSetList dataLineMsgSetList, LiteActivity liteActivity, QQAppInterface qQAppInterface) {
        this.F = 0;
        this.G = 0;
        this.I = -1;
        this.C = context;
        this.f32338i = dataLineMsgSetList;
        this.D = liteActivity;
        this.E = qQAppInterface;
        this.I = dataLineMsgSetList.size();
        this.f32339m = LayoutInflater.from(this.C);
        this.F = this.C.getResources().getDimensionPixelSize(R.dimen.f158611kg);
        this.G = this.C.getResources().getDimensionPixelSize(R.dimen.f158610kf);
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(h hVar, int i3, int i16) {
        Bitmap bitmap;
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.C.getResources(), R.drawable.f160142c15), i3, i16, false);
            bitmap = BaseImageUtil.round(createScaledBitmap, BaseAIOUtils.f(12.0f, this.D.getResources()));
            if (createScaledBitmap != null) {
                try {
                    createScaledBitmap.recycle();
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
                    }
                    if (bitmap == null) {
                    }
                }
            }
        } catch (OutOfMemoryError unused2) {
            bitmap = null;
        }
        if (bitmap == null) {
            hVar.c().f32411b.setBackgroundDrawable(new ClipDrawable(new BitmapDrawable(bitmap), 48, 2));
        } else {
            hVar.c().f32411b.setBackgroundDrawable(null);
        }
    }

    private void C(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        if (drawable == null) {
            view.setBackgroundDrawable(null);
            return;
        }
        Rect rect = new Rect();
        drawable.getPadding(rect);
        int paddingTop = view.getPaddingTop() + rect.top;
        int paddingLeft = view.getPaddingLeft() + rect.left;
        int paddingRight = view.getPaddingRight() + rect.right;
        int paddingBottom = view.getPaddingBottom() + rect.bottom;
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private Drawable l(DataLineMsgRecord dataLineMsgRecord) {
        boolean z16;
        Drawable drawable;
        boolean isSendFromLocal = dataLineMsgRecord.isSendFromLocal();
        int i3 = dataLineMsgRecord.msgtype;
        if (i3 != -2005 && i3 != -2009) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        Drawable drawable2 = this.f32337h;
        if (drawable2 == null || (drawable = this.f32336f) == null) {
            Resources resources = this.E.getApp().getResources();
            drawable = resources.getDrawable(R.drawable.b47);
            drawable2 = resources.getDrawable(R.drawable.f162446b42);
            this.f32336f = drawable;
            this.f32337h = drawable2;
        }
        if (isSendFromLocal) {
            return drawable;
        }
        return drawable2;
    }

    private void m(DataLineMsgRecord dataLineMsgRecord, RelativeLayout relativeLayout, h hVar) {
        Drawable l3;
        boolean z16;
        if (dataLineMsgRecord.vipBubbleID == JsonGrayBusiId.UI_RESERVE_100000_110000 && dataLineMsgRecord.msgtype == -1000) {
            com.rookery.translate.model.b b16 = com.rookery.translate.model.c.a(this.C.getApplicationContext()).b(dataLineMsgRecord.f203106msg, dataLineMsgRecord.msgId, mp.a.a(this.C.getApplicationContext()));
            if (b16 != null && b16.a().booleanValue() && !dataLineMsgRecord.isSendFromLocal()) {
                hVar.f32393m = com.tencent.mobileqq.bubble.f.a(100001, this.E, this.C.getResources(), this);
            } else {
                hVar.f32393m = com.tencent.mobileqq.bubble.f.a(100000, this.E, this.C.getResources(), this);
            }
        } else {
            hVar.f32393m = com.tencent.mobileqq.bubble.f.a(((ISVIPHandler) this.E.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getBubbleIdFromMessageRecord(dataLineMsgRecord), this.E, this.C.getResources(), this);
        }
        com.tencent.mobileqq.bubble.c cVar = hVar.f32393m;
        if (cVar != null) {
            cVar.k(relativeLayout, null);
            if (dataLineMsgRecord.msgtype != -1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            int i3 = dataLineMsgRecord.vipBubbleDiyTextId;
            if (i3 <= 0) {
                SVIPHandlerConstants.resolveDiyBubbleTextId(dataLineMsgRecord.vipBubbleID);
            }
            hVar.f32393m.c(this.E, dataLineMsgRecord.isSendFromLocal(), true, z17, relativeLayout, FontManagerConstants.getSenderUin(dataLineMsgRecord), i3);
        }
        int i16 = dataLineMsgRecord.msgtype;
        if ((i16 == -2005 || i16 == -2009 || i16 == -2009) && (l3 = l(dataLineMsgRecord)) != null) {
            C(relativeLayout, l3);
        }
        if (dataLineMsgRecord.msgtype == -2000) {
            C(relativeLayout, null);
        }
        if (dataLineMsgRecord.msgtype == -1000) {
            H(hVar, relativeLayout, dataLineMsgRecord, hVar.f32393m);
        }
        E(relativeLayout, dataLineMsgRecord);
    }

    private void n(GridView gridView) {
        int width = ((this.D.getWindowManager().getDefaultDisplay().getWidth() - BaseAIOUtils.f(147.0f, this.D.getResources())) - 2) / 3;
        gridView.setNumColumns(3);
        gridView.setColumnWidth(width);
        gridView.setHorizontalSpacing(1);
        gridView.setSelector(new ColorDrawable(0));
        gridView.setTag(Integer.valueOf(width));
        gridView.setClickable(true);
        gridView.setLongClickable(true);
        gridView.setAddStatesFromChildren(true);
    }

    private boolean q() {
        DataLineMsgSetList dataLineMsgSetList = this.f32338i;
        if (dataLineMsgSetList != null && dataLineMsgSetList.size() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(DataLineMsgRecord dataLineMsgRecord) {
        ForwardFileInfo U = ForwardFileOption.U(dataLineMsgRecord.trans2Entity());
        U.N(10002);
        Intent intent = new Intent(this.C.getApplicationContext(), (Class<?>) FileBrowserActivity.class);
        intent.putExtra("fileinfo", U);
        intent.putExtra("removemementity", true);
        intent.putExtra("not_forward", true);
        this.D.startActivityForResult(intent, 102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(DataLineMsgRecord dataLineMsgRecord) {
        ForwardFileInfo U = ForwardFileOption.U(dataLineMsgRecord.trans2Entity());
        U.N(10006);
        Intent intent = new Intent(this.C.getApplicationContext(), (Class<?>) TroopFileDetailBrowserActivity.class);
        intent.putExtra("fileinfo", U);
        intent.putExtra("removemementity", true);
        intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        intent.putExtra("not_forward", true);
        this.D.startActivityForResult(intent, 102);
    }

    private void t(h hVar, DataLineMsgSet dataLineMsgSet) {
        boolean z16;
        if (hVar == null || dataLineMsgSet == null) {
            return;
        }
        hVar.f32390f.setTag(hVar);
        if (dataLineMsgSet.isSendFromLocal() && dataLineMsgSet.hasFailed() && !dataLineMsgSet.hasSendingOrRecving() && !dataLineMsgSet.hasWaiting()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            hVar.f32390f.setVisibility(4);
            return;
        }
        hVar.f32390f.setVisibility(0);
        if (dataLineMsgSet.getOpType() == 1) {
            hVar.f32390f.setOnClickListener(this.D.W0);
        } else {
            hVar.f32390f.setOnClickListener(this.D.V0);
        }
    }

    private boolean u(h hVar, DataLineMsgSet dataLineMsgSet) {
        if (hVar == null) {
            return true;
        }
        if (hVar.a().f32397d == null) {
            return false;
        }
        if (dataLineMsgSet == null) {
            return true;
        }
        int completedCount = dataLineMsgSet.getCompletedCount();
        int totalCount = dataLineMsgSet.getTotalCount();
        DataLineMsgRecord firstItem = dataLineMsgSet.getFirstItem();
        if (firstItem == null) {
            return false;
        }
        if (dataLineMsgSet.getAt(0) != null && dataLineMsgSet.getAt(0).strMoloIconUrl != null) {
            hVar.a().f32394a.setAsyncImage(dataLineMsgSet.getAt(0).strMoloIconUrl);
        } else {
            hVar.a().f32394a.setImageResource(R.drawable.e8m);
        }
        if (dataLineMsgSet.getTotalCount() >= 2 && dataLineMsgSet.getAt(1) != null && dataLineMsgSet.getAt(1).strMoloIconUrl != null) {
            hVar.a().f32395b.setAsyncImage(dataLineMsgSet.getAt(1).strMoloIconUrl);
        } else {
            hVar.a().f32395b.setImageResource(R.drawable.e8m);
        }
        if (dataLineMsgSet.getTotalCount() >= 3 && dataLineMsgSet.getAt(2) != null && dataLineMsgSet.getAt(2).strMoloIconUrl != null) {
            hVar.a().f32396c.setAsyncImage(dataLineMsgSet.getAt(2).strMoloIconUrl);
        } else {
            hVar.a().f32396c.setImageResource(R.drawable.e8m);
        }
        if (dataLineMsgSet.getTotalCount() >= 4 && dataLineMsgSet.getAt(3) != null && dataLineMsgSet.getAt(3).strMoloIconUrl != null) {
            hVar.a().f32397d.setAsyncImage(dataLineMsgSet.getAt(3).strMoloIconUrl);
        } else {
            hVar.a().f32397d.setImageResource(R.drawable.e8m);
        }
        hVar.a().f32398e.setText(FileManagerUtil.cutLongName(dataLineMsgSet.getFileNames()));
        String str = firstItem.strMoloSource;
        if (str != null && str.contains(this.C.getString(R.string.c5n))) {
            hVar.a().f32399f.setVisibility(8);
            hVar.a().f32398e.setSingleLine(false);
            hVar.a().f32398e.setMaxLines(2);
        } else {
            hVar.a().f32399f.setVisibility(0);
            hVar.a().f32399f.setText(R.string.f171074c32);
            hVar.a().f32398e.setSingleLine(true);
        }
        hVar.a().f32400g.setText(n0.a.h(dataLineMsgSet.getFileTotalSize()));
        String str2 = firstItem.strMoloSource;
        if (str2 != null && !str2.equals("")) {
            hVar.a().f32404k.setText(firstItem.strMoloSource);
            hVar.a().f32404k.setVisibility(0);
            hVar.a().f32402i.setVisibility(0);
        } else {
            hVar.a().f32402i.setVisibility(8);
        }
        String str3 = firstItem.strMoloSrcIconUrl;
        if (str3 != null && !str3.equals("")) {
            hVar.a().f32403j.setImageURL(firstItem.strMoloSrcIconUrl);
            hVar.a().f32403j.setVisibility(0);
        } else {
            hVar.a().f32403j.setVisibility(8);
        }
        if (dataLineMsgSet.isCanceled()) {
            hVar.a().f32401h.setText(R.string.c4q);
        } else if (dataLineMsgSet.isFileComing()) {
            hVar.a().f32401h.setText(R.string.b7h);
        } else if (completedCount == totalCount) {
            hVar.a().f32401h.setText("" + totalCount);
        } else {
            hVar.a().f32401h.setText(completedCount + "/" + totalCount);
        }
        if ((!dataLineMsgSet.hasSendingOrRecving() && !dataLineMsgSet.hasWaiting()) || dataLineMsgSet.isFileComing()) {
            hVar.a().f32405l.setVisibility(4);
        } else {
            hVar.a().f32405l.setVisibility(0);
            hVar.a().f32405l.setProgress((int) (dataLineMsgSet.getTotalProcess() * 100.0f));
        }
        return true;
    }

    private boolean v(h hVar, DataLineMsgSet dataLineMsgSet) {
        if (hVar == null) {
            return true;
        }
        if (hVar.e().f32421a == null) {
            return false;
        }
        if (dataLineMsgSet == null) {
            return true;
        }
        int completedCount = dataLineMsgSet.getCompletedCount();
        int totalCount = dataLineMsgSet.getTotalCount();
        DataLineMsgRecord firstItem = dataLineMsgSet.getFirstItem();
        if (firstItem == null) {
            return false;
        }
        if (completedCount == totalCount) {
            hVar.e().f32421a.setText("" + totalCount);
        } else {
            hVar.e().f32421a.setText(completedCount + "/" + totalCount);
        }
        int intValue = ((Integer) hVar.e().f32422b.getTag()).intValue();
        e eVar = (e) hVar.e().f32422b.getAdapter();
        if (eVar == null) {
            hVar.e().f32422b.setAdapter((ListAdapter) new e(hVar, dataLineMsgSet, intValue));
        } else {
            eVar.f32346d = dataLineMsgSet;
            eVar.f32347e = hVar;
            eVar.b();
        }
        hVar.e().f32425e.setVisibility(8);
        dataLineMsgSet.printlog();
        if ((!dataLineMsgSet.hasSendingOrRecving() && !dataLineMsgSet.hasWaiting()) || dataLineMsgSet.isFileComing()) {
            hVar.e().f32423c.setVisibility(4);
            if (dataLineMsgSet.isCanceled()) {
                hVar.e().f32425e.setVisibility(0);
                hVar.e().f32426f.setText(R.string.c4q);
            } else if (dataLineMsgSet.isFileComing()) {
                hVar.e().f32425e.setVisibility(0);
                hVar.e().f32426f.setText(R.string.b7h);
            }
        } else {
            hVar.e().f32423c.setVisibility(0);
            hVar.e().f32423c.setProgress((int) (dataLineMsgSet.getTotalProcess() * 100.0f));
        }
        if (!dataLineMsgSet.isSendFromLocal()) {
            hVar.e().f32427g.setVisibility(8);
            if (firstItem.strMoloKey != null) {
                String str = firstItem.strMoloSource;
                if (str != null && !str.equals("")) {
                    hVar.e().f32429i.setText(firstItem.strMoloSource);
                    hVar.e().f32429i.setVisibility(0);
                    hVar.e().f32427g.setVisibility(0);
                } else {
                    hVar.e().f32427g.setVisibility(8);
                }
                String str2 = firstItem.strMoloSrcIconUrl;
                if (str2 != null && !str2.equals("")) {
                    hVar.e().f32428h.setImageURL(firstItem.strMoloSrcIconUrl);
                    hVar.e().f32428h.setVisibility(0);
                } else {
                    hVar.e().f32428h.setVisibility(8);
                }
            }
        }
        if (hVar.e().f32424d != null) {
            hVar.e().f32424d.setContentDescription(String.format(this.C.getString(R.string.c4_), Integer.valueOf(totalCount)));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(h hVar, DataLineMsgSet dataLineMsgSet) {
        DataLineMsgRecord firstItem;
        if (hVar == null || dataLineMsgSet == null || (firstItem = dataLineMsgSet.getFirstItem()) == null || hVar.c().f32410a == null) {
            return;
        }
        String d16 = com.tencent.mobileqq.filemanager.util.l.d(firstItem.path);
        hVar.c().f32410a.setAsyncClipSize(this.F, this.G);
        hVar.c().f32410a.setDefaultImageByMargin();
        hVar.c().f32410a.setIsDrawRound(true);
        hVar.c().f32414e.setVisibility(8);
        hVar.c().f32415f.setVisibility(8);
        if (d16 != null && new VFSFile(d16).exists()) {
            hVar.c().f32410a.setAsyncImage(d16);
        } else {
            String str = firstItem.thumbPath;
            if (str != null && str.length() > 0) {
                hVar.c().f32410a.setAsyncImage(firstItem.thumbPath);
            } else {
                hVar.c().f32410a.setImageDrawableDefault();
            }
        }
        if (firstItem.progress != 1.0f && firstItem.issuc) {
            long j3 = firstItem.fileMsgStatus;
            if (j3 != 1 && j3 != 2) {
                if (firstItem.isSendFromLocal()) {
                    hVar.c().f32411b.setVisibility(0);
                    hVar.c().f32411b.setProgress((int) (firstItem.progress * 100.0f));
                } else {
                    hVar.c().f32412c.setVisibility(0);
                }
                if (!dataLineMsgSet.isSendFromLocal()) {
                    hVar.c().f32417h.setVisibility(8);
                    if (firstItem.strMoloKey != null) {
                        String str2 = firstItem.strMoloSource;
                        if (str2 != null && !str2.equals("")) {
                            hVar.c().f32419j.setText(firstItem.strMoloSource);
                            hVar.c().f32419j.setVisibility(0);
                            hVar.c().f32417h.setVisibility(0);
                        } else {
                            hVar.c().f32417h.setVisibility(8);
                        }
                        String str3 = firstItem.strMoloSrcIconUrl;
                        if (str3 != null && !str3.equals("")) {
                            hVar.c().f32418i.setImageURL(firstItem.strMoloSrcIconUrl);
                            hVar.c().f32418i.setVisibility(0);
                        } else {
                            hVar.c().f32418i.setVisibility(8);
                        }
                    }
                }
                if (hVar.c().f32413d != null) {
                    hVar.c().f32413d.setContentDescription(HardCodeUtil.qqStr(R.string.l8r));
                }
                if (hVar.c().f32410a == null) {
                    hVar.c().f32410a.setContentDescription(HardCodeUtil.qqStr(R.string.l8j));
                    return;
                }
                return;
            }
        }
        hVar.c().f32411b.setVisibility(8);
        hVar.c().f32412c.setVisibility(8);
        if (firstItem.fileMsgStatus == 1 && firstItem.thumbPath == null) {
            hVar.c().f32415f.setVisibility(0);
            hVar.c().f32415f.setText(R.string.c3g);
        } else {
            hVar.c().f32415f.setVisibility(8);
        }
        if (!dataLineMsgSet.isSendFromLocal()) {
        }
        if (hVar.c().f32413d != null) {
        }
        if (hVar.c().f32410a == null) {
        }
    }

    protected void A() {
        this.H = false;
        new Handler().postDelayed(new Runnable() { // from class: com.dataline.util.DatalineSessionAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                DatalineSessionAdapter.this.H = true;
            }
        }, 1500L);
    }

    protected void E(View view, DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord.isSendFromLocal()) {
            view.setPadding(BaseChatItemLayout.c(), BaseChatItemLayout.P, BaseChatItemLayout.d(), BaseChatItemLayout.Q);
        } else {
            view.setPadding(BaseChatItemLayout.d(), BaseChatItemLayout.P, BaseChatItemLayout.c(), BaseChatItemLayout.Q);
        }
    }

    protected void F(int i3, h hVar, DataLineMsgSet dataLineMsgSet) {
        throw null;
    }

    public boolean G(long j3, ListView listView) {
        View childAt;
        DataLineMsgRecord t16 = this.E.getDataLineMsgProxy(DataLineMsgRecord.getDevTypeBySeId(j3)).t(j3);
        if (q()) {
            return false;
        }
        if (listView == null) {
            return true;
        }
        int setIndex = this.f32338i.getSetIndex(j3);
        if (setIndex == -1 || (childAt = listView.getChildAt(setIndex - listView.getFirstVisiblePosition())) == null || setIndex >= this.f32338i.size()) {
            return false;
        }
        DataLineMsgSet dataLineMsgSet = this.f32338i.get(setIndex);
        if (t16 != null && t16.fileMsgStatus == 1) {
            if (dataLineMsgSet.mUpdateMutiViewTick == 0) {
                dataLineMsgSet.mUpdateMutiViewTick = System.currentTimeMillis();
            } else {
                if (System.currentTimeMillis() - dataLineMsgSet.mUpdateMutiViewTick < 1000) {
                    return true;
                }
                dataLineMsgSet.mUpdateMutiViewTick = System.currentTimeMillis();
            }
        }
        if (dataLineMsgSet.isSingle()) {
            return true;
        }
        h hVar = (h) childAt.getTag();
        if (hVar == null) {
            return false;
        }
        int groupType = dataLineMsgSet.getGroupType();
        if (groupType != -2335) {
            if (groupType == -2000 && !v(hVar, dataLineMsgSet)) {
                return false;
            }
        } else if (dataLineMsgSet.getFirstItem().bIsMoloImage) {
            if (!v(hVar, dataLineMsgSet)) {
                return false;
            }
        } else if (!u(hVar, dataLineMsgSet)) {
            return false;
        }
        t(hVar, dataLineMsgSet);
        return true;
    }

    protected void H(h hVar, View view, DataLineMsgRecord dataLineMsgRecord, com.tencent.mobileqq.bubble.c cVar) {
        int i3;
        ColorStateList colorStateList;
        if (cVar == null) {
            return;
        }
        if (cVar.f200668a != 0 && cVar.j()) {
            if (cVar.f200677j == 0) {
                hVar.j().f32443a.setTextColor(-16777216);
            } else {
                hVar.j().f32443a.setTextColor(cVar.f200677j);
            }
            if (cVar.f200678k == 0) {
                hVar.j().f32443a.setLinkTextColor(view.getResources().getColorStateList(R.color.skin_chat_buble_link));
                return;
            } else {
                hVar.j().f32443a.setLinkTextColor(cVar.f200678k);
                return;
            }
        }
        Resources resources = view.getResources();
        if (dataLineMsgRecord.isSendFromLocal()) {
            i3 = R.color.skin_chat_buble_mine;
        } else {
            i3 = R.color.skin_chat_buble;
        }
        hVar.j().f32443a.setTextColor(resources.getColorStateList(i3));
        if (dataLineMsgRecord.isSendFromLocal()) {
            colorStateList = resources.getColorStateList(R.color.skin_chat_buble_link_mine);
        } else {
            colorStateList = resources.getColorStateList(R.color.skin_chat_buble_link);
        }
        hVar.j().f32443a.setLinkTextColor(colorStateList);
    }

    public void I(long j3, ListView listView, float f16) {
        int setIndex;
        View childAt;
        TextView textView;
        ProgressBar progressBar;
        MessageProgressTextView messageProgressTextView;
        if (listView == null || (setIndex = this.f32338i.getSetIndex(j3)) == -1 || (childAt = listView.getChildAt(setIndex - listView.getFirstVisiblePosition())) == null || setIndex >= this.f32338i.size()) {
            return;
        }
        DataLineMsgSet dataLineMsgSet = this.f32338i.get(setIndex);
        if (dataLineMsgSet.mUpdateProcessTick == 0) {
            dataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - dataLineMsgSet.mUpdateProcessTick < 1000) {
            return;
        } else {
            dataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
        }
        if (dataLineMsgSet.isSingle()) {
            DataLineMsgRecord d16 = this.E.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(j3)).d(j3);
            if (d16 == null) {
                return;
            }
            if (o(getItemViewType(setIndex))) {
                D(d16, childAt, f16);
                return;
            }
            float f17 = d16.progress;
            if (f16 < f17) {
                f16 = f17;
            }
            int i3 = d16.msgtype;
            if (i3 != -2335 && i3 != -2009 && i3 != -2005) {
                if (i3 == -2000 && (messageProgressTextView = (MessageProgressTextView) childAt.findViewById(R.id.dc7)) != null) {
                    messageProgressTextView.setProgress((int) (f16 * 100.0f));
                    return;
                }
                return;
            }
            if (d16.bIsMoloImage) {
                MessageProgressTextView messageProgressTextView2 = (MessageProgressTextView) childAt.findViewById(R.id.dc7);
                if (messageProgressTextView2 != null) {
                    messageProgressTextView2.setProgress((int) (f16 * 100.0f));
                    return;
                }
                return;
            }
            TextView textView2 = (TextView) childAt.findViewById(R.id.ca_);
            ProgressBar progressBar2 = (ProgressBar) childAt.findViewById(R.id.c_h);
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
                progressBar2.setProgress((int) (f16 * 100.0f));
            }
            if (textView2 != null) {
                textView2.setText(((int) (f16 * 100.0f)) + "%");
                return;
            }
            return;
        }
        h hVar = (h) childAt.getTag();
        if (hVar == null) {
            return;
        }
        int groupType = dataLineMsgSet.getGroupType();
        if (groupType != -2335 && groupType != -2009 && groupType != -2005) {
            textView = null;
            if (groupType != -2000) {
                progressBar = null;
            } else {
                progressBar = hVar.e().f32423c;
            }
        } else {
            textView = hVar.a().f32401h;
            progressBar = hVar.a().f32405l;
        }
        int completedCount = dataLineMsgSet.getCompletedCount();
        int totalCount = dataLineMsgSet.getTotalCount();
        if (textView != null) {
            if (completedCount == totalCount) {
                textView.setText("" + totalCount);
            } else {
                textView.setText(completedCount + "/" + totalCount);
            }
        }
        if (progressBar != null) {
            if (completedCount == totalCount) {
                progressBar.setVisibility(4);
            } else {
                progressBar.setVisibility(0);
                progressBar.setProgress((int) (dataLineMsgSet.getTotalProcess() * 100.0f));
            }
        }
    }

    @Override // com.dataline.util.l
    public long a(int i3) {
        return this.f32338i.get(i3).getMsgId();
    }

    @Override // com.dataline.util.l
    public long b(int i3) {
        return this.f32338i.get(i3).getTime();
    }

    @Override // com.dataline.util.l
    public int c() {
        return this.f32338i.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (q()) {
            return 1;
        }
        return this.f32338i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (q() || i3 >= this.f32338i.size()) {
            return null;
        }
        return this.f32338i.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (q() || i3 >= this.f32338i.size()) {
            return 13;
        }
        DataLineMsgSet dataLineMsgSet = this.f32338i.get(i3);
        boolean isSendFromLocal = dataLineMsgSet.isSendFromLocal();
        int groupType = dataLineMsgSet.getGroupType();
        if (groupType != -5041) {
            if (groupType != -5000) {
                if (groupType != -2335) {
                    if (groupType != -2073) {
                        if (groupType != -2009 && groupType != -2005) {
                            if (groupType != -2000) {
                                if (groupType != -1000) {
                                    return 12;
                                }
                                if (isSendFromLocal) {
                                    return 7;
                                }
                                return 0;
                            }
                            if (dataLineMsgSet.isSingle()) {
                                if (!isSendFromLocal) {
                                    return 1;
                                }
                                return 8;
                            }
                            if (!isSendFromLocal) {
                                return 2;
                            }
                            return 9;
                        }
                        if (dataLineMsgSet.isSingle()) {
                            if (isSendFromLocal) {
                                return 10;
                            }
                            return 3;
                        }
                        if (isSendFromLocal) {
                            return 11;
                        }
                        return 4;
                    }
                    return 16;
                }
                DataLineMsgRecord firstItem = dataLineMsgSet.getFirstItem();
                if (firstItem != null) {
                    if (dataLineMsgSet.isSingle()) {
                        if (firstItem.bIsMoloImage) {
                            return 1;
                        }
                        return 5;
                    }
                    if (firstItem.bIsMoloImage) {
                        return 2;
                    }
                    return 6;
                }
                return 14;
            }
            return 14;
        }
        return 15;
    }

    @Override // android.widget.Adapter
    @TargetApi(8)
    public View getView(int i3, View view, ViewGroup viewGroup) {
        DataLineMsgSet dataLineMsgSet;
        h hVar;
        View view2;
        View inflate;
        ColorStateList colorStateList;
        View view3;
        View view4;
        if (q()) {
            if (view == null) {
                h hVar2 = new h();
                view4 = this.f32339m.inflate(R.layout.f167893l2, (ViewGroup) null);
                TextView textView = (TextView) view4.findViewById(R.id.ecc);
                if (this.D.f32050i0 == 1) {
                    textView.setText(R.string.agr);
                }
                view4.setTag(hVar2);
            } else {
                view4 = view;
            }
            view4.setVisibility(4);
            this.D.t3();
            view2 = view4;
        } else {
            this.D.t3();
            if (i3 < this.f32338i.size() && (dataLineMsgSet = this.f32338i.get(i3)) != null) {
                int itemViewType = getItemViewType(i3);
                DataLineMsgRecord firstItem = dataLineMsgSet.getFirstItem();
                if (view == null) {
                    hVar = new h();
                    if (o(itemViewType)) {
                        view2 = k(itemViewType, hVar, dataLineMsgSet);
                    } else if (itemViewType == 12) {
                        view2 = this.f32339m.inflate(R.layout.f167888kq, (ViewGroup) null);
                        hVar.r((TextView) view2.findViewById(R.id.bdo));
                        if (hVar.h() != null) {
                            hVar.h().setText(R.string.c4h);
                        }
                    } else if (itemViewType == 14) {
                        view2 = this.f32339m.inflate(R.layout.f167878kf, (ViewGroup) null);
                        h.b b16 = hVar.b();
                        b16.f32408a = (TextView) view2.findViewById(R.id.graybar);
                        String qqStr = HardCodeUtil.qqStr(R.string.f171828l92);
                        String qqStr2 = HardCodeUtil.qqStr(R.string.l8f);
                        b16.f32408a.setMaxLines(2);
                        SpannableString spannableString = new SpannableString("\u8fd8\u60f3\u628a\u6587\u4ef6\u53d1\u5230\u597d\u53cb\u624b\u673a\uff1f\u5feb\u6765\u7528\n" + qqStr + qqStr2);
                        spannableString.setSpan(new b(), 16, qqStr.length() + 16, 33);
                        b16.f32408a.setHighlightColor(0);
                        b16.f32408a.setText(spannableString);
                        b16.f32408a.setMovementMethod(LinkMovementMethod.getInstance());
                        b16.f32408a.setVisibility(8);
                    } else if (itemViewType == 15) {
                        h.g m3 = hVar.m();
                        View inflate2 = LayoutInflater.from(this.C).inflate(R.layout.f168654an0, (ViewGroup) null);
                        m3.f32448a = (TextView) inflate2.findViewById(R.id.graybar);
                        view2 = inflate2;
                    } else {
                        if (itemViewType == 16) {
                            h.g m16 = hVar.m();
                            inflate = LayoutInflater.from(this.C).inflate(R.layout.f167769gn, (ViewGroup) null);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.graybar);
                            m16.f32448a = textView2;
                            textView2.setMovementMethod(null);
                            m16.f32448a.setTextColor(inflate.getResources().getColorStateList(R.color.f156896el));
                        } else {
                            if (!dataLineMsgSet.isSendFromLocal()) {
                                inflate = this.f32339m.inflate(R.layout.f167889kr, (ViewGroup) null);
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                                Drawable drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
                                int devTypeBySet = DataLineMsgRecord.getDevTypeBySet(dataLineMsgSet);
                                if (devTypeBySet == 0) {
                                    drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
                                } else if (devTypeBySet == 1) {
                                    drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_ipad_recent);
                                } else if (devTypeBySet == 2) {
                                    drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_user_aio);
                                }
                                imageView.setImageDrawable(drawable);
                            } else {
                                inflate = this.f32339m.inflate(R.layout.f167890kx, (ViewGroup) null);
                            }
                            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f1j);
                            hVar.f32392i = relativeLayout;
                            relativeLayout.setTag(hVar);
                            hVar.f32392i.setClickable(true);
                            hVar.f32392i.setLongClickable(true);
                            hVar.f32392i.setOnClickListener(this.J);
                            hVar.f32392i.setOnLongClickListener(this.D.f32039a1);
                            hVar.f32392i.setOnTouchListener(this.D.f32041b1);
                            hVar.f32392i.setAddStatesFromChildren(true);
                            switch (itemViewType) {
                                case 0:
                                case 7:
                                    RelativeLayout relativeLayout2 = (RelativeLayout) this.f32339m.inflate(R.layout.f167891ky, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout2);
                                    hVar.j().f32444b = relativeLayout2;
                                    hVar.j().f32443a = (TextView) inflate.findViewById(R.id.jfb);
                                    hVar.j().f32444b.setAddStatesFromChildren(true);
                                    hVar.j().f32443a.setTag(hVar);
                                    hVar.j().f32443a.setOnClickListener(this.J);
                                    hVar.j().f32443a.setClickable(true);
                                    hVar.j().f32443a.setOnLongClickListener(this.D.f32039a1);
                                    hVar.j().f32443a.setOnTouchListener(this.D.f32041b1);
                                    hVar.j().f32443a.setLongClickable(true);
                                    hVar.j().f32443a.setMovementMethod(LinkMovementMethod.getInstance());
                                    hVar.j().f32443a.setSpannableFactory(QQText.SPANNABLE_FACTORY);
                                    if (dataLineMsgSet.isSendFromLocal()) {
                                        colorStateList = this.C.getResources().getColorStateList(R.color.skin_chat_buble_mine);
                                    } else {
                                        colorStateList = this.C.getResources().getColorStateList(R.color.skin_chat_buble);
                                    }
                                    hVar.j().f32443a.setTextColor(colorStateList);
                                    hVar.t((ProgressBar) inflate.findViewById(R.id.io5));
                                    if (hVar.k() != null) {
                                        hVar.k().setVisibility(8);
                                        break;
                                    }
                                    break;
                                case 1:
                                case 8:
                                    RelativeLayout relativeLayout3 = (RelativeLayout) this.f32339m.inflate(R.layout.f167879kg, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout3);
                                    hVar.f32392i.setGravity(17);
                                    hVar.c().f32413d = relativeLayout3;
                                    hVar.c().f32410a = (AsyncImageView) inflate.findViewById(R.id.image);
                                    hVar.c().f32411b = (MessageProgressTextView) inflate.findViewById(R.id.dc7);
                                    hVar.c().f32412c = (ProgressBar) inflate.findViewById(R.id.i0s);
                                    hVar.c().f32414e = (LinearLayout) inflate.findViewById(R.id.j1y);
                                    hVar.c().f32415f = (TextView) inflate.findViewById(R.id.ayr);
                                    hVar.c().f32416g = (TextView) inflate.findViewById(R.id.keo);
                                    if (!dataLineMsgSet.isSendFromLocal()) {
                                        hVar.c().f32419j = (TextView) inflate.findViewById(R.id.ken);
                                        hVar.c().f32418i = (URLImageView) inflate.findViewById(R.id.d_y);
                                        hVar.c().f32417h = (LinearLayout) inflate.findViewById(R.id.iz5);
                                    }
                                    if (dataLineMsgSet.isSendFromLocal()) {
                                        hVar.c().f32412c.setVisibility(8);
                                        hVar.c().f32411b.setVisibility(0);
                                        B(hVar, this.F, this.G);
                                    } else {
                                        hVar.c().f32412c.setVisibility(0);
                                        hVar.c().f32411b.setVisibility(8);
                                    }
                                    hVar.c().f32410a.setAsyncClipSize(this.F, this.G);
                                    hVar.c().f32410a.setDefaultImageByMargin();
                                    if (!o.f179546a) {
                                        hVar.c().f32410a.setAdjustViewBounds(true);
                                    } else {
                                        hVar.c().f32411b.setBackgroundDrawable(new com.tencent.mobileqq.activity.aio.item.a(HWColorFormat.COLOR_FormatVendorStartUnused, this.D.getDensity() * 12.0f));
                                        hVar.c().f32411b.setDisplayInTextView(false, (int) TypedValue.applyDimension(2, 15.0f, this.C.getResources().getDisplayMetrics()), -1);
                                    }
                                    hVar.c().f32410a.setIsDrawRound(true);
                                    hVar.c().f32413d.setContentDescription(HardCodeUtil.qqStr(R.string.l8p));
                                    hVar.c().f32410a.setContentDescription(HardCodeUtil.qqStr(R.string.l8x));
                                    break;
                                case 2:
                                case 9:
                                    RelativeLayout relativeLayout4 = (RelativeLayout) this.f32339m.inflate(R.layout.f167881ki, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout4);
                                    hVar.e().f32424d = relativeLayout4;
                                    hVar.e().f32421a = (TextView) inflate.findViewById(R.id.fsa);
                                    hVar.e().f32422b = (GridView) inflate.findViewById(R.id.fri);
                                    hVar.e().f32423c = (ProgressBar) inflate.findViewById(R.id.c_h);
                                    hVar.e().f32425e = (LinearLayout) inflate.findViewById(R.id.j1y);
                                    hVar.e().f32426f = (TextView) inflate.findViewById(R.id.keo);
                                    if (!dataLineMsgSet.isSendFromLocal()) {
                                        hVar.e().f32429i = (TextView) inflate.findViewById(R.id.ken);
                                        hVar.e().f32428h = (URLImageView) inflate.findViewById(R.id.d_y);
                                        hVar.e().f32427g = (LinearLayout) inflate.findViewById(R.id.iz5);
                                    }
                                    hVar.e().f32424d.setAddStatesFromChildren(true);
                                    hVar.e().f32421a.setTag(hVar);
                                    hVar.e().f32421a.setOnClickListener(this.J);
                                    hVar.e().f32421a.setClickable(true);
                                    hVar.e().f32421a.setOnLongClickListener(this.D.f32039a1);
                                    hVar.e().f32421a.setOnTouchListener(this.D.f32041b1);
                                    hVar.e().f32421a.setLongClickable(true);
                                    n(hVar.e().f32422b);
                                    break;
                                case 3:
                                case 10:
                                    RelativeLayout relativeLayout5 = (RelativeLayout) this.f32339m.inflate(R.layout.f167874kb, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout5);
                                    if (FontSettingManager.getFontLevel() > 17.0f) {
                                        hVar.a().f32406m = relativeLayout5;
                                        int f16 = BaseAIOUtils.f(70.0f, this.C.getResources());
                                        RelativeLayout relativeLayout6 = (RelativeLayout) inflate.findViewById(R.id.c_t);
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f16);
                                        layoutParams.addRule(10, R.id.c_w);
                                        relativeLayout5.updateViewLayout(relativeLayout6, layoutParams);
                                        AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.c_6);
                                        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f16, f16);
                                        layoutParams2.addRule(9, R.id.c_t);
                                        layoutParams2.addRule(15, R.id.c_t);
                                        relativeLayout6.updateViewLayout(asyncImageView, layoutParams2);
                                        hVar.a().f32394a = asyncImageView;
                                        TextView textView3 = (TextView) inflate.findViewById(R.id.ca5);
                                        textView3.setGravity(16);
                                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                                        layoutParams3.addRule(1, R.id.c_6);
                                        layoutParams3.addRule(11, R.id.c_t);
                                        layoutParams3.addRule(10, R.id.c_t);
                                        layoutParams3.setMargins(BaseAIOUtils.f(10.0f, this.C.getResources()), 0, 0, 0);
                                        relativeLayout6.updateViewLayout(textView3, layoutParams3);
                                        hVar.a().f32398e = textView3;
                                        TextView textView4 = (TextView) inflate.findViewById(R.id.ca_);
                                        textView4.setGravity(5);
                                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                                        layoutParams4.addRule(11, R.id.c_t);
                                        layoutParams4.addRule(12, R.id.c_t);
                                        relativeLayout6.updateViewLayout(textView4, layoutParams4);
                                        hVar.a().f32401h = textView4;
                                        TextView textView5 = (TextView) inflate.findViewById(R.id.ca9);
                                        textView5.setGravity(17);
                                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                                        layoutParams5.addRule(11, R.id.c_t);
                                        layoutParams5.addRule(2, R.id.ca_);
                                        relativeLayout6.updateViewLayout(textView5, layoutParams5);
                                        hVar.a().f32400g = textView5;
                                    } else {
                                        hVar.a().f32406m = relativeLayout5;
                                        hVar.a().f32394a = (AsyncImageView) inflate.findViewById(R.id.c_6);
                                        hVar.a().f32398e = (TextView) inflate.findViewById(R.id.ca5);
                                        hVar.a().f32400g = (TextView) inflate.findViewById(R.id.ca9);
                                        hVar.a().f32401h = (TextView) inflate.findViewById(R.id.ca_);
                                    }
                                    hVar.a().f32405l = (ProgressBar) inflate.findViewById(R.id.c_h);
                                    hVar.a().f32394a.setDefaultImage(R.drawable.h7o);
                                    hVar.a().f32394a.setIsDrawRound(false);
                                    break;
                                case 5:
                                    RelativeLayout relativeLayout7 = (RelativeLayout) this.f32339m.inflate(R.layout.f167873ka, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout7);
                                    hVar.a().f32406m = relativeLayout7;
                                    hVar.a().f32394a = (AsyncImageView) inflate.findViewById(R.id.c_6);
                                    hVar.a().f32398e = (TextView) inflate.findViewById(R.id.ca5);
                                    hVar.a().f32399f = (TextView) inflate.findViewById(R.id.c_k);
                                    hVar.a().f32400g = (TextView) inflate.findViewById(R.id.ca9);
                                    hVar.a().f32401h = (TextView) inflate.findViewById(R.id.ca_);
                                    hVar.a().f32405l = (ProgressBar) inflate.findViewById(R.id.c_h);
                                    hVar.a().f32404k = (TextView) inflate.findViewById(R.id.ken);
                                    hVar.a().f32403j = (URLImageView) inflate.findViewById(R.id.d_y);
                                    hVar.a().f32402i = (LinearLayout) inflate.findViewById(R.id.iz5);
                                    hVar.a().f32394a.setDefaultImage(R.drawable.e8l);
                                    hVar.a().f32394a.setIsDrawRound(false);
                                    break;
                                case 6:
                                    RelativeLayout relativeLayout8 = (RelativeLayout) this.f32339m.inflate(R.layout.f167880kh, (ViewGroup) null);
                                    hVar.f32392i.addView(relativeLayout8);
                                    hVar.a().f32406m = relativeLayout8;
                                    hVar.a().f32394a = (AsyncImageView) inflate.findViewById(R.id.c_7);
                                    hVar.a().f32395b = (AsyncImageView) inflate.findViewById(R.id.c_8);
                                    hVar.a().f32396c = (AsyncImageView) inflate.findViewById(R.id.c_9);
                                    hVar.a().f32397d = (AsyncImageView) inflate.findViewById(R.id.c__);
                                    hVar.a().f32398e = (TextView) inflate.findViewById(R.id.ca5);
                                    hVar.a().f32399f = (TextView) inflate.findViewById(R.id.c_k);
                                    hVar.a().f32400g = (TextView) inflate.findViewById(R.id.ca9);
                                    hVar.a().f32401h = (TextView) inflate.findViewById(R.id.ca_);
                                    hVar.a().f32405l = (ProgressBar) inflate.findViewById(R.id.c_h);
                                    hVar.a().f32404k = (TextView) inflate.findViewById(R.id.ken);
                                    hVar.a().f32403j = (URLImageView) inflate.findViewById(R.id.d_y);
                                    hVar.a().f32402i = (LinearLayout) inflate.findViewById(R.id.iz5);
                                    hVar.a().f32394a.setDefaultImage(R.drawable.e8m);
                                    hVar.a().f32395b.setDefaultImage(R.drawable.e8m);
                                    hVar.a().f32396c.setDefaultImage(R.drawable.e8m);
                                    hVar.a().f32397d.setDefaultImage(R.drawable.e8m);
                                    hVar.a().f32394a.setIsDrawRound(false);
                                    hVar.a().f32395b.setIsDrawRound(false);
                                    hVar.a().f32396c.setIsDrawRound(false);
                                    hVar.a().f32397d.setIsDrawRound(false);
                                    break;
                            }
                            hVar.p((ImageView) inflate.findViewById(R.id.f165106by4));
                            hVar.u((TextView) inflate.findViewById(R.id.bdp));
                        }
                        view2 = inflate;
                    }
                    view2.setTag(hVar);
                } else {
                    hVar = (h) view.getTag();
                    view2 = view;
                }
                hVar.q(dataLineMsgSet);
                if (itemViewType != 12) {
                    if (itemViewType == 14) {
                        if (ThemeUtil.isInNightMode(this.E)) {
                            Object tag = this.D.f32038a0.getTag(R.id.f163834n);
                            if (tag instanceof ChatBackgroundDrawable) {
                                hVar.b().f32408a.setTextColor(ColorStateList.valueOf(t.h(((ChatBackgroundDrawable) tag).getBitmap())));
                            }
                        }
                    } else if (itemViewType == 15) {
                        h.g m17 = hVar.m();
                        m17.f32448a.setText(FileManagerUtil.getClickableTips(firstItem.getExtInfoFromExtStr("tim_aio_file_tips"), firstItem.getExtInfoFromExtStr("tim_aio_file_link"), new c(firstItem)));
                        m17.f32448a.setMovementMethod(LinkMovementMethod.getInstance());
                        m17.f32448a.setHighlightColor(view2.getResources().getColor(17170445));
                    } else {
                        if (itemViewType == 16) {
                            h.g m18 = hVar.m();
                            if (firstItem != null && !TextUtils.isEmpty(firstItem.f203106msg) && m18.f32448a != null && firstItem.f203106msg.indexOf(HardCodeUtil.qqStr(R.string.l8s)) >= 0) {
                                m18.f32448a.setText(FileManagerUtil.getClickableTips(firstItem.f203106msg, HardCodeUtil.qqStr(R.string.l8g), new d(firstItem)));
                                m18.f32448a.setMovementMethod(LinkMovementMethod.getInstance());
                                m18.f32448a.setHighlightColor(view2.getResources().getColor(17170445));
                            }
                        }
                        if (firstItem != null) {
                            switch (itemViewType) {
                                case 0:
                                case 7:
                                    hVar.j().f32445c = firstItem.f203106msg;
                                    hVar.j().f32446d = firstItem.sessionid;
                                    TextView textView6 = hVar.j().f32443a;
                                    String str = AppConstants.INTENT_ACCOUNT_INFO_UPDATE;
                                    QQText qQText = new QQText(firstItem.f203106msg, 45, 32, 6000);
                                    qQText.setBizSrc("biz_src_jc_aio");
                                    textView6.setText(qQText);
                                    textView6.setVisibility(0);
                                    if (hVar.k() != null) {
                                        if (firstItem.issuc && firstItem.progress != 1.0f) {
                                            hVar.k().setVisibility(0);
                                        } else {
                                            hVar.k().setVisibility(8);
                                        }
                                    }
                                    textView6.setTextSize(0, ChatTextSizeSettingActivity.H2(this.C.getApplicationContext()));
                                    break;
                                case 1:
                                case 8:
                                    y(hVar, dataLineMsgSet);
                                    break;
                                case 2:
                                case 9:
                                    v(hVar, dataLineMsgSet);
                                    break;
                                case 3:
                                case 10:
                                    x(hVar, dataLineMsgSet);
                                    break;
                                case 5:
                                    w(hVar, dataLineMsgSet);
                                    break;
                                case 6:
                                    u(hVar, dataLineMsgSet);
                                    break;
                            }
                            if (o(itemViewType)) {
                                F(itemViewType, hVar, dataLineMsgSet);
                            } else {
                                m(firstItem, hVar.f32392i, hVar);
                                if (ThemeUtil.isDefaultTheme()) {
                                    int paddingLeft = hVar.f32392i.getPaddingLeft();
                                    int paddingRight = hVar.f32392i.getPaddingRight();
                                    int paddingTop = hVar.f32392i.getPaddingTop();
                                    int paddingBottom = hVar.f32392i.getPaddingBottom();
                                    if (!dataLineMsgSet.isSendFromLocal()) {
                                        hVar.f32392i.setPadding(paddingLeft + ((int) (this.D.getDensity() * 2.0f)), paddingTop, paddingRight, paddingBottom);
                                    } else {
                                        hVar.f32392i.setPadding(paddingLeft, paddingTop, paddingRight + ((int) (this.D.getDensity() * 2.0f)), paddingBottom);
                                    }
                                }
                                if (ThemeUtil.isInNightMode(this.E)) {
                                    Object tag2 = this.D.f32038a0.getTag(R.id.f163834n);
                                    if (tag2 instanceof ChatBackgroundDrawable) {
                                        hVar.l().setTextColor(ColorStateList.valueOf(t.h(((ChatBackgroundDrawable) tag2).getBitmap())));
                                    }
                                }
                                if (d(dataLineMsgSet.getMsgId())) {
                                    CharSequence d16 = en.d(this.C, 3, dataLineMsgSet.getTime() * 1000);
                                    hVar.l().setVisibility(0);
                                    hVar.l().setText(d16);
                                } else {
                                    hVar.l().setVisibility(8);
                                }
                                t(hVar, dataLineMsgSet);
                            }
                        }
                    }
                }
            } else {
                view2 = view;
                view3 = null;
                EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                return view3;
            }
        }
        view3 = view2;
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 17;
    }

    protected View k(int i3, h hVar, DataLineMsgSet dataLineMsgSet) {
        throw null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        f();
        if (QLog.isColorLevel()) {
            QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
        }
    }

    protected boolean o(int i3) {
        throw null;
    }

    protected boolean p() {
        return this.H;
    }

    protected void w(h hVar, DataLineMsgSet dataLineMsgSet) {
        DataLineMsgRecord firstItem;
        if (hVar == null || dataLineMsgSet == null || (firstItem = dataLineMsgSet.getFirstItem()) == null) {
            return;
        }
        int i3 = (int) (firstItem.progress * 100.0f);
        if (firstItem.strMoloIconUrl != null) {
            hVar.a().f32394a.setAsyncImage(firstItem.strMoloIconUrl);
        } else {
            hVar.a().f32394a.setImageResource(R.drawable.e8m);
        }
        hVar.a().f32398e.setText(FileManagerUtil.cutLongName(firstItem.filename));
        String str = firstItem.strMoloSource;
        if (str != null && str.contains(this.C.getString(R.string.c5n))) {
            hVar.a().f32399f.setVisibility(8);
            hVar.a().f32398e.setSingleLine(false);
            hVar.a().f32398e.setMaxLines(2);
        } else {
            hVar.a().f32399f.setVisibility(0);
            hVar.a().f32399f.setText(R.string.f171074c32);
            hVar.a().f32398e.setSingleLine(true);
        }
        hVar.a().f32400g.setText(n0.a.h(firstItem.filesize));
        String str2 = firstItem.strMoloSource;
        if (str2 != null && !str2.equals("")) {
            hVar.a().f32404k.setText(firstItem.strMoloSource);
            hVar.a().f32404k.setVisibility(0);
            hVar.a().f32402i.setVisibility(0);
        } else {
            hVar.a().f32402i.setVisibility(8);
        }
        String str3 = firstItem.strMoloSrcIconUrl;
        if (str3 != null && !str3.equals("")) {
            hVar.a().f32403j.setImageURL(firstItem.strMoloSrcIconUrl);
            hVar.a().f32403j.setVisibility(0);
        } else {
            hVar.a().f32403j.setVisibility(8);
        }
        long j3 = firstItem.fileMsgStatus;
        if (j3 == 2) {
            hVar.a().f32401h.setText(R.string.c4q);
        } else if (j3 == 1) {
            hVar.a().f32401h.setText(R.string.b7h);
        } else if (firstItem.progress == 1.0f && firstItem.issuc) {
            hVar.a().f32401h.setText(R.string.b7a);
        } else if (!firstItem.issuc) {
            hVar.a().f32401h.setText(R.string.b7e);
        } else {
            hVar.a().f32401h.setText(i3 + "%");
        }
        if (firstItem.progress != 1.0f && firstItem.issuc) {
            long j16 = firstItem.fileMsgStatus;
            if (j16 != 1 && j16 != 2) {
                hVar.a().f32405l.setVisibility(0);
                hVar.a().f32405l.setProgress(i3);
                return;
            }
        }
        hVar.a().f32405l.setVisibility(4);
    }

    protected void x(h hVar, DataLineMsgSet dataLineMsgSet) {
        DataLineMsgRecord firstItem;
        if (hVar == null || dataLineMsgSet == null || (firstItem = dataLineMsgSet.getFirstItem()) == null) {
            return;
        }
        int i3 = (int) (firstItem.progress * 100.0f);
        hVar.a().f32394a.setIsDrawRound(false);
        FileManagerUtil.setFileIcon(hVar.a().f32394a, firstItem);
        hVar.a().f32398e.setText(FileManagerUtil.cutLongName(firstItem.filename));
        hVar.a().f32400g.setText(n0.a.h(firstItem.filesize));
        if (firstItem.isSendFromLocal()) {
            if (firstItem.fileMsgStatus == 2) {
                hVar.a().f32401h.setText(R.string.c4q);
            } else if (firstItem.progress == 1.0f && firstItem.issuc) {
                hVar.a().f32401h.setText(R.string.b7g);
            } else if (!firstItem.issuc) {
                if (firstItem.nOpType == 1) {
                    hVar.a().f32401h.setText(R.string.b7e);
                } else {
                    hVar.a().f32401h.setText(R.string.b7f);
                }
            } else {
                hVar.a().f32401h.setText(i3 + "%");
            }
        } else {
            long j3 = firstItem.fileMsgStatus;
            if (j3 == 2) {
                hVar.a().f32401h.setText(R.string.c4q);
            } else if (j3 == 1) {
                hVar.a().f32401h.setText(R.string.b7h);
            } else if (firstItem.progress == 1.0f && firstItem.issuc) {
                hVar.a().f32401h.setText(R.string.b7a);
            } else if (!firstItem.issuc) {
                hVar.a().f32401h.setText(R.string.b7e);
            } else {
                hVar.a().f32401h.setText(i3 + "%");
            }
        }
        if (firstItem.progress != 1.0f && firstItem.issuc) {
            long j16 = firstItem.fileMsgStatus;
            if (j16 != 1 && j16 != 2) {
                hVar.a().f32405l.setVisibility(0);
                hVar.a().f32405l.setProgress(i3);
                return;
            }
        }
        hVar.a().f32405l.setVisibility(4);
    }

    public void z(DataLineMsgSetList dataLineMsgSetList) {
        this.f32338i = dataLineMsgSetList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(DataLineMsgRecord dataLineMsgRecord, View view, float f16) {
    }
}
