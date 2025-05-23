package com.tencent.state.common.tag;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareLibraryTagPanelBinding;
import com.tencent.state.template.dialog.SceneCommonDialogs;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 V2\u00020\u0001:\u0001VB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u00105\u001a\u00020\u0005H\u0014J\b\u00106\u001a\u00020\u0005H\u0014J\b\u00107\u001a\u00020\u0005H\u0014J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H$J\b\u0010<\u001a\u00020=H$J\b\u0010>\u001a\u00020=H$J\b\u0010?\u001a\u00020=H$J\b\u0010@\u001a\u00020=H$J\b\u0010A\u001a\u000209H\u0002J\b\u0010B\u001a\u000209H\u0002J\u0010\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020;H\u0002J\b\u0010E\u001a\u000209H\u0002J\u0010\u0010F\u001a\u0002092\u0006\u0010D\u001a\u00020;H\u0002J\b\u0010G\u001a\u000209H\u0002J\b\u0010H\u001a\u000209H\u0002J\b\u0010I\u001a\u000209H\u0002J\b\u0010J\u001a\u000209H\u0002J\b\u0010K\u001a\u000209H\u0002J*\u0010L\u001a\u0002092\b\u0010M\u001a\u0004\u0018\u00010\u001d2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020O0\u001cj\b\u0012\u0004\u0012\u00020O`\u001eH\u0002J*\u0010P\u001a\u0002092\b\u0010M\u001a\u0004\u0018\u00010&2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020O0\u001cj\b\u0012\u0004\u0012\u00020O`\u001eH\u0002J\b\u0010R\u001a\u000209H$J\b\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u000209H\u0014J\b\u0010U\u001a\u000209H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010%\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020&\u0018\u0001`\u001eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101RJ\u00102\u001a>\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e03j\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e`4X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/tencent/state/common/tag/BaseTagPanel;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "isSingle", "", "checkConflict", "(Landroid/content/Context;ZZ)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryTagPanelBinding;", "currentDeskMateTag", "", "getCurrentDeskMateTag", "()Ljava/lang/String;", "setCurrentDeskMateTag", "(Ljava/lang/String;)V", "currentDeskMateTagId", "getCurrentDeskMateTagId", "setCurrentDeskMateTagId", "currentOwnerCategory", "getCurrentOwnerCategory", "setCurrentOwnerCategory", "currentOwnerTagId", "getCurrentOwnerTagId", "setCurrentOwnerTagId", "deskMateAdapter", "Lcom/tencent/state/common/tag/TagAdapter;", "deskMateTagList", "Ljava/util/ArrayList;", "Lcom/tencent/state/common/tag/CommonTagInfo;", "Lkotlin/collections/ArrayList;", ViewStickEventHelper.IS_SHOW, "()Z", "setShow", "(Z)V", "openTime", "", "ownerCategoryList", "Lcom/tencent/state/common/tag/TagCategoryInfo;", "getOwnerCategoryList", "()Ljava/util/ArrayList;", "setOwnerCategoryList", "(Ljava/util/ArrayList;)V", "ownerTagAdapter", "reporter", "Lcom/tencent/state/square/IReporter;", "getReporter", "()Lcom/tencent/state/square/IReporter;", "setReporter", "(Lcom/tencent/state/square/IReporter;)V", "tagSignMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "canShowDeskMateTagContainer", "canShowFocusTagContainer", "canShowSyncInSquareContainer", "dismiss", "", "getDialogTagSetInfo", "Lcom/tencent/state/common/tag/DialogTagSetInfo;", "getOperatorStringId", "", "getOwnerTagTitle", "getSceneType", "getSyncTitle", "initData", "initDeskMateTagContainer", "initDeskMateTagData", "tagInfo", "initFocusTagContainer", "initFocusTagData", "initOperatorBtn", "initSyncInSquareContainer", "initTopSign", "initView", "initWindow", "loadDeskMateLastSelect", "info", "deskMateTag", "Lcom/tencent/state/common/tag/TagItemData;", "loadOwnerLastSelect", "ownerTag", "onOperatorClick", "refreshSyncIcon", "reportPanelShowEvent", "show", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class BaseTagPanel extends Dialog {
    private static final long SHOW_CD_MS = 1000;
    private static final String TAG = "BaseTagPanel";
    private final VasSquareLibraryTagPanelBinding binding;
    private final boolean checkConflict;
    private String currentDeskMateTag;
    private String currentDeskMateTagId;
    private String currentOwnerCategory;
    private String currentOwnerTagId;
    private TagAdapter deskMateAdapter;
    private final ArrayList<CommonTagInfo> deskMateTagList;
    private boolean isShow;
    private final boolean isSingle;
    private long openTime;
    private ArrayList<TagCategoryInfo> ownerCategoryList;
    private TagAdapter ownerTagAdapter;
    private IReporter reporter;
    private final HashMap<String, ArrayList<CommonTagInfo>> tagSignMap;
    private static final FastClickUtils fastClickUtils = new FastClickUtils(1000);

    public /* synthetic */ BaseTagPanel(Context context, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, (i3 & 4) != 0 ? true : z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        DialogTagSetInfo dialogTagSetInfo = getDialogTagSetInfo();
        initFocusTagData(dialogTagSetInfo);
        initDeskMateTagData(dialogTagSetInfo);
        this.openTime = System.currentTimeMillis();
    }

    private final void initDeskMateTagContainer() {
        if (!canShowDeskMateTagContainer()) {
            LinearLayout linearLayout = this.binding.deskMateContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.deskMateContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.deskMateContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.deskMateContainer");
        linearLayout2.setVisibility(0);
        TagAdapter tagAdapter = new TagAdapter();
        this.deskMateAdapter = tagAdapter;
        tagAdapter.setTagClickListener(new OnTagClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initDeskMateTagContainer$1
            @Override // com.tencent.state.common.tag.OnTagClickListener
            public void onClick(String tagName, int position) {
                ArrayList arrayList;
                Object obj;
                Map<String, Object> mutableMapOf;
                Intrinsics.checkNotNullParameter(tagName, "tagName");
                BaseTagPanel.this.setCurrentDeskMateTag(tagName);
                BaseTagPanel baseTagPanel = BaseTagPanel.this;
                arrayList = baseTagPanel.deskMateTagList;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(BaseTagPanel.this.getCurrentDeskMateTag(), ((CommonTagInfo) obj).getText())) {
                            break;
                        }
                    }
                }
                CommonTagInfo commonTagInfo = (CommonTagInfo) obj;
                baseTagPanel.setCurrentDeskMateTagId(commonTagInfo != null ? commonTagInfo.getId() : null);
                String currentDeskMateTagId = BaseTagPanel.this.getCurrentDeskMateTagId();
                if (currentDeskMateTagId != null) {
                    IReporter reporter = BaseTagPanel.this.getReporter();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FIND_DESKMATE_ID, currentDeskMateTagId));
                    reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DESKMATE_CATEGORY_CLICK, mutableMapOf);
                }
            }
        });
        RecyclerView recyclerView = this.binding.deskMateTagList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.deskMateTagList");
        recyclerView.setAdapter(this.deskMateAdapter);
        RecyclerView recyclerView2 = this.binding.deskMateTagList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.deskMateTagList");
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2, 0, false));
    }

    private final void initDeskMateTagData(DialogTagSetInfo tagInfo) {
        String str;
        if (canShowDeskMateTagContainer()) {
            ArrayList<TagItemData> arrayList = new ArrayList<>();
            Iterator<T> it = tagInfo.getDeskMateTags().iterator();
            while (it.hasNext()) {
                arrayList.add(new TagItemData(((CommonTagInfo) it.next()).getText(), false, 2, null));
            }
            this.deskMateTagList.addAll(tagInfo.getDeskMateTags());
            if (!tagInfo.getDeskMateTags().isEmpty()) {
                str = tagInfo.getDeskMateTags().get(0).getId();
            } else {
                str = "";
            }
            this.currentDeskMateTagId = str;
            loadDeskMateLastSelect(tagInfo.getDeskMateSelectTag(), arrayList);
        }
    }

    private final void initFocusTagContainer() {
        if (!canShowFocusTagContainer()) {
            LinearLayout linearLayout = this.binding.ownerTagContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.ownerTagContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.ownerTagContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.ownerTagContainer");
        linearLayout2.setVisibility(0);
        TagAdapter tagAdapter = new TagAdapter();
        this.ownerTagAdapter = tagAdapter;
        tagAdapter.setTagClickListener(new OnTagClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initFocusTagContainer$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
            
                if (r1 != null) goto L10;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
            /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.state.common.tag.OnTagClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(String tagName, int position) {
                VasSquareLibraryTagPanelBinding vasSquareLibraryTagPanelBinding;
                HashMap hashMap;
                String str;
                HashMap hashMap2;
                String str2;
                ArrayList<TagCategoryInfo> ownerCategoryList;
                Map<String, Object> mutableMapOf;
                Object obj;
                VasSquareLibraryTagPanelBinding vasSquareLibraryTagPanelBinding2;
                Object random;
                Intrinsics.checkNotNullParameter(tagName, "tagName");
                vasSquareLibraryTagPanelBinding = BaseTagPanel.this.binding;
                TextView textView = vasSquareLibraryTagPanelBinding.ownerTagText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerTagText");
                hashMap = BaseTagPanel.this.tagSignMap;
                ArrayList arrayList = (ArrayList) hashMap.get(tagName);
                if (arrayList != null) {
                    random = CollectionsKt___CollectionsKt.random(arrayList, Random.INSTANCE);
                    CommonTagInfo commonTagInfo = (CommonTagInfo) random;
                    if (commonTagInfo != null) {
                        str = commonTagInfo.getText();
                    }
                }
                str = "";
                textView.setText(str);
                BaseTagPanel.this.setCurrentOwnerCategory(tagName);
                BaseTagPanel baseTagPanel = BaseTagPanel.this;
                hashMap2 = baseTagPanel.tagSignMap;
                ArrayList arrayList2 = (ArrayList) hashMap2.get(BaseTagPanel.this.getCurrentOwnerCategory());
                TagCategoryInfo tagCategoryInfo = null;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        vasSquareLibraryTagPanelBinding2 = BaseTagPanel.this.binding;
                        TextView textView2 = vasSquareLibraryTagPanelBinding2.ownerTagText;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ownerTagText");
                        if (Intrinsics.areEqual(textView2.getText(), ((CommonTagInfo) obj).getText())) {
                            break;
                        }
                    }
                    CommonTagInfo commonTagInfo2 = (CommonTagInfo) obj;
                    if (commonTagInfo2 != null) {
                        str2 = commonTagInfo2.getId();
                        baseTagPanel.setCurrentOwnerTagId(str2);
                        ownerCategoryList = BaseTagPanel.this.getOwnerCategoryList();
                        if (ownerCategoryList != null) {
                            Iterator<T> it5 = ownerCategoryList.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                Object next = it5.next();
                                if (Intrinsics.areEqual(((TagCategoryInfo) next).getCategoryName(), BaseTagPanel.this.getCurrentOwnerCategory())) {
                                    tagCategoryInfo = next;
                                    break;
                                }
                            }
                            tagCategoryInfo = tagCategoryInfo;
                        }
                        if (tagCategoryInfo == null) {
                            IReporter reporter = BaseTagPanel.this.getReporter();
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FIND_FOCUS_ID, tagCategoryInfo.getCategory()), TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(BaseTagPanel.this.getSceneType())));
                            reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CATEGORY_CLICK, mutableMapOf);
                            return;
                        }
                        return;
                    }
                }
                str2 = null;
                baseTagPanel.setCurrentOwnerTagId(str2);
                ownerCategoryList = BaseTagPanel.this.getOwnerCategoryList();
                if (ownerCategoryList != null) {
                }
                if (tagCategoryInfo == null) {
                }
            }
        });
        RecyclerView recyclerView = this.binding.ownerTagList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ownerTagList");
        recyclerView.setAdapter(this.ownerTagAdapter);
        RecyclerView recyclerView2 = this.binding.ownerTagList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.ownerTagList");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.binding.refresh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initFocusTagContainer$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HashMap hashMap;
                ArrayList arrayList;
                CommonTagInfo commonTagInfo;
                VasSquareLibraryTagPanelBinding vasSquareLibraryTagPanelBinding;
                String str;
                Map<String, Object> mutableMapOf;
                Object random;
                VasSquareLibraryTagPanelBinding vasSquareLibraryTagPanelBinding2;
                hashMap = BaseTagPanel.this.tagSignMap;
                ArrayList arrayList2 = (ArrayList) hashMap.get(BaseTagPanel.this.getCurrentOwnerCategory());
                if (arrayList2 != null) {
                    arrayList = new ArrayList();
                    for (Object obj : arrayList2) {
                        String text = ((CommonTagInfo) obj).getText();
                        vasSquareLibraryTagPanelBinding2 = BaseTagPanel.this.binding;
                        Intrinsics.checkNotNullExpressionValue(vasSquareLibraryTagPanelBinding2.ownerTagText, "binding.ownerTagText");
                        if (!Intrinsics.areEqual(text, r6.getText())) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    random = CollectionsKt___CollectionsKt.random(arrayList, Random.INSTANCE);
                    commonTagInfo = (CommonTagInfo) random;
                } else {
                    commonTagInfo = null;
                }
                vasSquareLibraryTagPanelBinding = BaseTagPanel.this.binding;
                TextView textView = vasSquareLibraryTagPanelBinding.ownerTagText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerTagText");
                if (commonTagInfo == null || (str = commonTagInfo.getText()) == null) {
                    str = "";
                }
                textView.setText(str);
                BaseTagPanel.this.setCurrentOwnerTagId(commonTagInfo != null ? commonTagInfo.getId() : null);
                IReporter reporter = BaseTagPanel.this.getReporter();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(BaseTagPanel.this.getSceneType())));
                reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_REFRESH_CLICK, mutableMapOf);
            }
        });
    }

    private final void initFocusTagData(DialogTagSetInfo tagInfo) {
        if (canShowFocusTagContainer()) {
            ArrayList<TagItemData> arrayList = new ArrayList<>();
            for (TagCategoryInfo tagCategoryInfo : tagInfo.getOwnerTags()) {
                arrayList.add(new TagItemData(tagCategoryInfo.getCategoryName(), false, 2, null));
                this.tagSignMap.put(tagCategoryInfo.getCategoryName(), tagCategoryInfo.getTags());
            }
            this.ownerCategoryList = tagInfo.getOwnerTags();
            loadOwnerLastSelect(tagInfo.getOwnerSelectTag(), arrayList);
        }
    }

    private final void initOperatorBtn() {
        this.binding.selfUseTip.setText(getSyncTitle());
        this.binding.ownerTagTitle.setText(getOwnerTagTitle());
        this.binding.operator.setText(getOperatorStringId());
        this.binding.operator.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initOperatorBtn$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTagPanel.this.onOperatorClick();
                BaseTagPanel.this.dismiss();
            }
        });
    }

    private final void initSyncInSquareContainer() {
        if (!canShowSyncInSquareContainer()) {
            LinearLayout linearLayout = this.binding.showInSquare;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.showInSquare");
            linearLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = this.binding.showInSquare;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.showInSquare");
            linearLayout2.setVisibility(0);
            refreshSyncIcon();
            this.binding.showInSquareIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initSyncInSquareContainer$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseTagPanel.this.setShow(!r2.getIsShow());
                    BaseTagPanel.this.refreshSyncIcon();
                }
            });
        }
    }

    private final void initTopSign() {
        this.binding.panelTopSign.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.tag.BaseTagPanel$initTopSign$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTagPanel.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        initTopSign();
        initFocusTagContainer();
        initDeskMateTagContainer();
        initSyncInSquareContainer();
        initOperatorBtn();
    }

    private final void loadDeskMateLastSelect(CommonTagInfo info, ArrayList<TagItemData> deskMateTag) {
        Object obj;
        if (deskMateTag.isEmpty()) {
            return;
        }
        if (info == null) {
            deskMateTag.get(0).setCheck(true);
            this.currentDeskMateTag = deskMateTag.get(0).getText();
        } else {
            Iterator<T> it = deskMateTag.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((TagItemData) obj).getText(), info.getText())) {
                        break;
                    }
                }
            }
            TagItemData tagItemData = (TagItemData) obj;
            if (tagItemData == null) {
                return;
            }
            tagItemData.setCheck(true);
            this.currentDeskMateTag = tagItemData.getText();
            this.currentDeskMateTagId = info.getId();
        }
        TagAdapter tagAdapter = this.deskMateAdapter;
        if (tagAdapter != null) {
            tagAdapter.setData(deskMateTag);
        }
    }

    private final void loadOwnerLastSelect(TagCategoryInfo info, ArrayList<TagItemData> ownerTag) {
        Object random;
        CommonTagInfo commonTagInfo;
        String str;
        Object random2;
        if (ownerTag.isEmpty()) {
            return;
        }
        Object obj = null;
        if (info == null) {
            ownerTag.get(0).setCheck(true);
            ArrayList<CommonTagInfo> arrayList = this.tagSignMap.get(ownerTag.get(0).getText());
            if (arrayList != null) {
                random2 = CollectionsKt___CollectionsKt.random(arrayList, Random.INSTANCE);
                commonTagInfo = (CommonTagInfo) random2;
            } else {
                commonTagInfo = null;
            }
            TextView textView = this.binding.ownerTagText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerTagText");
            if (commonTagInfo == null || (str = commonTagInfo.getText()) == null) {
                str = "";
            }
            textView.setText(str);
            this.currentOwnerCategory = ownerTag.get(0).getText();
            this.currentOwnerTagId = commonTagInfo != null ? commonTagInfo.getId() : null;
        } else {
            Iterator<T> it = ownerTag.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((TagItemData) next).getText(), info.getCategoryName())) {
                    obj = next;
                    break;
                }
            }
            TagItemData tagItemData = (TagItemData) obj;
            if (tagItemData == null) {
                return;
            }
            tagItemData.setCheck(true);
            random = CollectionsKt___CollectionsKt.random(info.getTags(), Random.INSTANCE);
            CommonTagInfo commonTagInfo2 = (CommonTagInfo) random;
            TextView textView2 = this.binding.ownerTagText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.ownerTagText");
            textView2.setText(commonTagInfo2.getText());
            this.currentOwnerCategory = tagItemData.getText();
            this.currentOwnerTagId = commonTagInfo2.getId();
        }
        TagAdapter tagAdapter = this.ownerTagAdapter;
        if (tagAdapter != null) {
            tagAdapter.setData(ownerTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshSyncIcon() {
        if (this.isShow) {
            this.binding.showInSquareIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i_f));
        } else {
            this.binding.showInSquareIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i_e));
        }
    }

    protected boolean canShowDeskMateTagContainer() {
        return true;
    }

    protected boolean canShowFocusTagContainer() {
        return true;
    }

    protected boolean canShowSyncInSquareContainer() {
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        TagAdapter tagAdapter = this.ownerTagAdapter;
        if (tagAdapter != null) {
            tagAdapter.clearTagClickListener();
        }
        TagAdapter tagAdapter2 = this.deskMateAdapter;
        if (tagAdapter2 != null) {
            tagAdapter2.clearTagClickListener();
        }
        reportPanelShowEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCurrentDeskMateTag() {
        return this.currentDeskMateTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCurrentDeskMateTagId() {
        return this.currentDeskMateTagId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCurrentOwnerCategory() {
        return this.currentOwnerCategory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCurrentOwnerTagId() {
        return this.currentOwnerTagId;
    }

    protected abstract DialogTagSetInfo getDialogTagSetInfo();

    protected abstract int getOperatorStringId();

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<TagCategoryInfo> getOwnerCategoryList() {
        return this.ownerCategoryList;
    }

    protected abstract int getOwnerTagTitle();

    /* JADX INFO: Access modifiers changed from: protected */
    public final IReporter getReporter() {
        return this.reporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getSceneType();

    protected abstract int getSyncTitle();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: isSingle, reason: from getter */
    public final boolean getIsSingle() {
        return this.isSingle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onOperatorClick();

    protected void reportPanelShowEvent() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXP_TIME, Long.valueOf((System.currentTimeMillis() - this.openTime) / 1000)), TuplesKt.to(SquareReportConst.Key.KEY_FOCUS_WRITE_TYPE, Integer.valueOf(!this.isSingle ? 1 : 0)), TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(getSceneType())));
        this.reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_WRITE_EXP, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCurrentDeskMateTag(String str) {
        this.currentDeskMateTag = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCurrentDeskMateTagId(String str) {
        this.currentDeskMateTagId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCurrentOwnerCategory(String str) {
        this.currentOwnerCategory = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCurrentOwnerTagId(String str) {
        this.currentOwnerTagId = str;
    }

    protected final void setOwnerCategoryList(ArrayList<TagCategoryInfo> arrayList) {
        this.ownerCategoryList = arrayList;
    }

    protected final void setReporter(IReporter iReporter) {
        Intrinsics.checkNotNullParameter(iReporter, "<set-?>");
        this.reporter = iReporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setShow(boolean z16) {
        this.isShow = z16;
    }

    @Override // android.app.Dialog
    public void show() {
        if (fastClickUtils.isFastDoubleClick()) {
            SquareBaseKt.getSquareLog().w(TAG, "BaseTagPanel \u91cd\u590d\u6253\u5f00");
            return;
        }
        if (this.checkConflict) {
            SceneCommonDialogs sceneCommonDialogs = SceneCommonDialogs.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            sceneCommonDialogs.checkSceneConflictDialog(context, new Function0<Unit>() { // from class: com.tencent.state.common.tag.BaseTagPanel$show$1
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
                    BaseTagPanel.this.initView();
                    BaseTagPanel.this.initData();
                    super/*android.app.Dialog*/.show();
                }
            }, new Function0<Unit>() { // from class: com.tencent.state.common.tag.BaseTagPanel$show$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        initView();
        initData();
        super.show();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTagPanel(Context context, boolean z16, boolean z17) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isSingle = z16;
        this.checkConflict = z17;
        VasSquareLibraryTagPanelBinding inflate = VasSquareLibraryTagPanelBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryTagPanel\u2026utInflater.from(context))");
        this.binding = inflate;
        this.isShow = true;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.tagSignMap = new HashMap<>();
        this.deskMateTagList = new ArrayList<>();
        setContentView(inflate.getMRv());
        initWindow();
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), -2);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }
}
