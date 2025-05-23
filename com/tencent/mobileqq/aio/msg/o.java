package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.MixMsgUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0016\u0018\u0000 *2\u00020\u0001:\u0003^_`B\u001b\b\u0002\u0012\u0006\u0010Z\u001a\u00020\u0018\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b[\u0010\\B\u0011\b\u0016\u0012\u0006\u0010Z\u001a\u00020\u0018\u00a2\u0006\u0004\b[\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J8\u0010\u0012\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0017\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\u0006\u0010(\u001a\u00020\tJ\u0006\u0010)\u001a\u00020\tJ\b\u0010*\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\u0006\u0010.\u001a\u00020\u0006J\b\u0010/\u001a\u00020\u0010H\u0016R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u00100R\\\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000203`42\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000203`48\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\\\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000203`42\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000203`48\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u00109RB\u0010C\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020>\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020>\u0018\u0001`48\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u00107\u001a\u0004\b@\u00109\"\u0004\bA\u0010BR2\u0010M\u001a\u0012\u0012\u0004\u0012\u00020E0Dj\b\u0012\u0004\u0012\u00020E`F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010U\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010Y\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010P\u001a\u0004\bW\u0010R\"\u0004\bX\u0010T\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/o;", "Lcom/tencent/mobileqq/aio/msg/w;", "Lcom/tencent/mobileqq/aio/msg/o$c;", "x2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "t2", "u2", "", "y2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "textElements", "preIsPic", "nxtIsPic", "", "textViewIndex", "r2", "", "Lcom/tencent/mobileqq/aio/msg/o$b;", "msgItemList", "index", "w2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "newMsgItem", "l", "viewType", "getSubViewType", "o2", "W0", "", SemanticAttributes.DbSystemValues.H2, "Landroid/content/Context;", "context", "Y0", "X0", "m2", "q2", "f1", "g2", "e2", "V0", "v2", "getViewType", "Lcom/tencent/mobileqq/aio/msg/o$c;", "mixItemList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<set-?>", "Z0", "Ljava/util/HashMap;", "p2", "()Ljava/util/HashMap;", "mQQTextMap", ICustomDataEditor.STRING_ARRAY_PARAM_1, "getMQQTextMapWithoutMagic", "mQQTextMapWithoutMagic", "Landroid/graphics/drawable/Drawable;", "b1", ICustomDataEditor.NUMBER_PARAM_2, "setFontDrawableMap", "(Ljava/util/HashMap;)V", "fontDrawableMap", "Ljava/util/HashSet;", "Landroid/graphics/Typeface;", "Lkotlin/collections/HashSet;", "c1", "Ljava/util/HashSet;", "getTypefaceCacheMap", "()Ljava/util/HashSet;", "setTypefaceCacheMap", "(Ljava/util/HashSet;)V", "typefaceCacheMap", "", "d1", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_PARAM_2, "()F", "setQqTextSize", "(F)V", "qqTextSize", "e1", "getOriginTextSize", "setOriginTextSize", "originTextSize", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/mobileqq/aio/msg/o$c;)V", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class o extends w {
    static IPatchRedirector $redirector_;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g1, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, Integer> f190175g1;

    /* renamed from: h1, reason: collision with root package name */
    private static final boolean f190176h1;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final c mixItemList;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    private HashMap<Integer, CharSequence> mQQTextMap;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, CharSequence> mQQTextMapWithoutMagic;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<Integer, Drawable> fontDrawableMap;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<Typeface> typefaceCacheMap;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    private float qqTextSize;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    private float originTextSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/o$a;", "", "", "MAX_IMAGE_SIZE", "I", "", "isFilter", "Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sSubViewTypeMap", "Ljava/util/HashMap;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.o$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R+\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/o$b;", "", "", "e", "d", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "textElements", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "marketFaceElement", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<MsgElement> textElements;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgElement picElement;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgElement marketFaceElement;

        public b(@Nullable ArrayList<MsgElement> arrayList, @Nullable MsgElement msgElement, @Nullable MsgElement msgElement2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, arrayList, msgElement, msgElement2);
                return;
            }
            this.textElements = arrayList;
            this.picElement = msgElement;
            this.marketFaceElement = msgElement2;
        }

        @Nullable
        public final MsgElement a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MsgElement) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.marketFaceElement;
        }

        @Nullable
        public final MsgElement b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MsgElement) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.picElement;
        }

        @Nullable
        public final ArrayList<MsgElement> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.textElements;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            if (this.marketFaceElement != null) {
                return true;
            }
            return false;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            if (this.picElement != null) {
                return true;
            }
            return false;
        }

        public /* synthetic */ b(ArrayList arrayList, MsgElement msgElement, MsgElement msgElement2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, msgElement, (i3 & 4) != 0 ? null : msgElement2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, arrayList, msgElement, msgElement2, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/o$c;", "", "", "a", "I", "c", "()I", "f", "(I)V", "picSize", "b", "e", "marketFaceSize", "d", "g", "textSize", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msg/o$b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int picSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int marketFaceSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int textSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<b> itemList;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.itemList = new ArrayList<>();
            }
        }

        @NotNull
        public final ArrayList<b> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.itemList;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.marketFaceSize;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.picSize;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.textSize;
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.marketFaceSize = i3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.picSize = i3;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.textSize = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        INSTANCE = new Companion(null);
        f190175g1 = new HashMap<>();
        f190176h1 = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("101864", true);
    }

    o(MsgRecord msgRecord, c cVar) {
        super(msgRecord);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord, (Object) cVar);
            return;
        }
        this.mQQTextMap = new HashMap<>();
        this.mQQTextMapWithoutMagic = new HashMap<>();
        this.mixItemList = cVar == null ? x2() : cVar;
        this.typefaceCacheMap = new HashSet<>();
    }

    private final void r2(ArrayList<MsgElement> textElements, boolean preIsPic, boolean nxtIsPic, int textViewIndex) {
        boolean endsWith$default;
        boolean startsWith$default;
        if (textElements.isEmpty()) {
            return;
        }
        CharSequence a16 = com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.a(textElements);
        if (Intrinsics.areEqual(a16.toString(), "\n") && preIsPic && nxtIsPic) {
            return;
        }
        if (preIsPic) {
            startsWith$default = StringsKt__StringsKt.startsWith$default(a16, (CharSequence) "\n", false, 2, (Object) null);
            if (startsWith$default) {
                a16 = a16.subSequence(1, a16.length()).toString();
            }
        }
        if (nxtIsPic) {
            endsWith$default = StringsKt__StringsKt.endsWith$default(a16, (CharSequence) "\n", false, 2, (Object) null);
            if (endsWith$default) {
                a16 = a16.subSequence(0, a16.length() - 1).toString();
            }
        }
        int d16 = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.d();
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        CharSequence qQText = ((IQQTextApi) companion.a(IQQTextApi.class)).getQQText(a16.toString(), d16, com.tencent.qqnt.emotion.constant.b.b(), null, this);
        ((IQQTextApi) companion.a(IQQTextApi.class)).setBizSrc(qQText, "biz_src_jc_aio");
        this.mQQTextMap.put(Integer.valueOf(textViewIndex), qQText);
    }

    private final boolean t2(MsgElement element) {
        TextElement textElement;
        if ((this instanceof u) && getMsgRecord().elements.size() == 2 && (textElement = element.textElement) != null && Intrinsics.areEqual(textElement.content, "\n")) {
            return true;
        }
        return false;
    }

    private final boolean u2(MsgElement element) {
        boolean z16;
        TextElement textElement = element.textElement;
        if (textElement != null) {
            if (f190176h1) {
                String str = textElement.content;
                if (str != null && str.length() != 0) {
                    return false;
                }
            } else {
                String str2 = textElement.content;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && !Intrinsics.areEqual(element.textElement.content, "\n")) {
                    return false;
                }
            }
            return true;
        }
        if (element.faceElement != null) {
            return false;
        }
        return true;
    }

    private final boolean w2(List<b> msgItemList, int index) {
        if (index < 0 || index >= msgItemList.size()) {
            return false;
        }
        return msgItemList.get(index).e();
    }

    private final c x2() {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        Iterator<MsgElement> it = getMsgRecord().elements.iterator();
        ArrayList arrayList2 = arrayList;
        while (it.hasNext()) {
            MsgElement element = it.next();
            int i3 = element.elementType;
            if (i3 == 2) {
                if (!arrayList2.isEmpty()) {
                    cVar.a().add(new b(arrayList2, null, null, 4, null));
                    cVar.g(cVar.d() + 1);
                    arrayList2 = new ArrayList();
                }
                cVar.f(cVar.c() + 1);
                cVar.a().add(new b(null, element, null, 4, null));
            } else if (i3 == 11) {
                if (!arrayList2.isEmpty()) {
                    cVar.a().add(new b(arrayList2, null, null));
                    cVar.g(cVar.d() + 1);
                    arrayList2 = new ArrayList();
                }
                cVar.e(cVar.b() + 1);
                cVar.a().add(new b(null, null, element));
            } else if (i3 != 7) {
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (t2(element) || !u2(element)) {
                    arrayList2.add(element);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            cVar.a().add(new b(arrayList2, null, null, 4, null));
            cVar.g(cVar.d() + 1);
        }
        return cVar;
    }

    private final void y2() {
        List<b> o26 = o2();
        int size = o26.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            b bVar = o26.get(i16);
            if (bVar.c() != null) {
                r2(bVar.c(), w2(o26, i16 - 1), w2(o26, i16 + 1), i3);
                i3++;
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public int V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        if (v2()) {
            return 4;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean W0() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (!super.W0()) {
            return false;
        }
        if (h2().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        Collection<Drawable> values;
        y03.c cVar;
        Typeface e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.X0();
        q2();
        Y1(a.a(this));
        HashMap<Integer, Drawable> c16 = a.c(this, this.mQQTextMap, (int) this.qqTextSize);
        this.fontDrawableMap = c16;
        if (c16 != null && (values = c16.values()) != null) {
            for (Object obj : values) {
                if (obj instanceof y03.c) {
                    cVar = (y03.c) obj;
                } else {
                    cVar = null;
                }
                if (cVar != null && (e16 = AIOMsgTextView.INSTANCE.e(cVar.n())) != null) {
                    this.typefaceCacheMap.add(e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        y2();
        Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        float dimension = BaseApplication.context.getResources().getDimension(R.dimen.ayp);
        this.originTextSize = dimension;
        this.qqTextSize = dimension;
        this.mQQTextMapWithoutMagic = new HashMap<>(this.mQQTextMap);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 13, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new o(targetMsgRecord, this.mixItemList);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return !v2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ype);
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ype);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ype);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, viewType)).intValue();
        }
        if (!MixMsgUtils.f194090a.a()) {
            return (this.mixItemList.d() * 200) + this.mixItemList.c() + this.mixItemList.b();
        }
        String str = this.mixItemList.d() + "_" + this.mixItemList.c() + "_" + this.mixItemList.b();
        HashMap<String, Integer> hashMap = f190175g1;
        Integer num = hashMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        int size = hashMap.size() + 1;
        hashMap.put(str, Integer.valueOf(size));
        return size;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 3;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<Map.Entry<Integer, CharSequence>> it = this.mQQTextMap.entrySet().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getValue().toString());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.aio.msg.w, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        o oVar = (o) newMsgItem;
        oVar.mQQTextMap = this.mQQTextMap;
        oVar.mQQTextMapWithoutMagic = this.mQQTextMapWithoutMagic;
        oVar.Y1(x0());
        oVar.originTextSize = this.originTextSize;
        oVar.qqTextSize = this.qqTextSize;
        oVar.fontDrawableMap = this.fontDrawableMap;
        oVar.typefaceCacheMap = this.typefaceCacheMap;
    }

    public final void m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        HashMap<Integer, Drawable> hashMap = this.fontDrawableMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.typefaceCacheMap.clear();
        this.qqTextSize = this.originTextSize;
        if (!this.mQQTextMapWithoutMagic.isEmpty()) {
            this.mQQTextMap = new HashMap<>(this.mQQTextMapWithoutMagic);
        }
    }

    @Nullable
    public final HashMap<Integer, Drawable> n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fontDrawableMap;
    }

    @NotNull
    public final List<b> o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mixItemList.a();
    }

    @NotNull
    public final HashMap<Integer, CharSequence> p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mQQTextMap;
    }

    public final void q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        int c16 = com.tencent.qqnt.aio.utils.n.f352308a.c(this);
        boolean z16 = true;
        if (c16 != 1) {
            if (c16 == 2000) {
                IFontManager.Companion companion = IFontManager.INSTANCE;
                float e16 = companion.e();
                if (FontSettingManager.getFontLevel() != 18.0f) {
                    z16 = false;
                }
                if (z16) {
                    e16 = companion.c();
                }
                this.qqTextSize = this.originTextSize * e16;
                return;
            }
            return;
        }
        for (Map.Entry<Integer, CharSequence> entry : this.mQQTextMap.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "iterator.next()");
            Map.Entry<Integer, CharSequence> entry2 = entry;
            IFontManager iFontManager = (IFontManager) QRoute.api(IFontManager.class);
            CharSequence value = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "next.value");
            entry2.setValue(iFontManager.parseMagicFont(value, getMsgRecord().peerUin, getMsgId()));
        }
    }

    public final float s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.qqTextSize;
    }

    public final boolean v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.mixItemList.b() > 1) {
            return true;
        }
        if (this.mixItemList.b() > 0 && (this.mixItemList.c() > 0 || this.mixItemList.d() > 0)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(@NotNull MsgRecord msgRecord) {
        this(msgRecord, null);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgRecord);
    }
}
