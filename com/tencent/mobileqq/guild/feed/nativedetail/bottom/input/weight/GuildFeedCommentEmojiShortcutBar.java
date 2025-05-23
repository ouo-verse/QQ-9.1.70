package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedCommentEmojiShortcutBar;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedCommentEmojiShortcutBar extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f220600f = cx.a(28.0f);

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f220601d;

    /* renamed from: e, reason: collision with root package name */
    private b f220602e;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f220603a;

        /* renamed from: b, reason: collision with root package name */
        private int f220604b;

        /* renamed from: c, reason: collision with root package name */
        private String f220605c;

        public a(int i3, int i16, String str) {
            this.f220603a = i3;
            this.f220604b = i16;
            this.f220605c = str;
        }

        public int a() {
            return this.f220604b;
        }

        public String toString() {
            return "EmoticonBean{mServerId=" + this.f220603a + ", mLocalId=" + this.f220604b + ", mDesc='" + this.f220605c + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, a aVar);
    }

    public GuildFeedCommentEmojiShortcutBar(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        for (int i3 = 0; i3 < SystemAndEmojiEmoticonInfo.COLUMNNUM_SYSTEM_AND_EMOJI; i3++) {
            final a aVar = this.f220601d.get(i3);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(QQSysFaceUtil.getFaceDrawable(aVar.a()));
            int i16 = f220600f;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
            layoutParams.weight = 1.0f;
            addView(imageView, layoutParams);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: zk1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedCommentEmojiShortcutBar.this.e(aVar, view);
                }
            });
        }
    }

    private void d() {
        String[] split = "277,63,319,66,294,182,5,76".split(",");
        int min = Math.min(split.length, SystemAndEmojiEmoticonInfo.COLUMNNUM_SYSTEM_AND_EMOJI);
        for (int i3 = 0; i3 < min; i3++) {
            String str = split[i3];
            int parseStr2Int = StringUtil.parseStr2Int(str, -1);
            if (parseStr2Int == -1) {
                RFWLog.w("GuildFeedCommentEmojiShortcutBar", RFWLog.USR, "parseStr2Int error, str=" + str);
            } else {
                int convertToLocal = QQSysFaceUtil.convertToLocal(parseStr2Int);
                this.f220601d.add(new a(parseStr2Int, convertToLocal, QQSysFaceUtil.getFaceDescription(convertToLocal)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.f220602e;
        if (bVar != null) {
            bVar.a(view, aVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void c(b bVar) {
        this.f220602e = bVar;
        d();
        b();
    }

    public GuildFeedCommentEmojiShortcutBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedCommentEmojiShortcutBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f220601d = new ArrayList();
    }
}
