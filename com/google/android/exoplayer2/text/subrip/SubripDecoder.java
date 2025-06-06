package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private static final String TAG = "SubripDecoder";
    private final StringBuilder textBuilder;

    public SubripDecoder() {
        super(TAG);
        this.textBuilder = new StringBuilder();
    }

    private static long parseTimecode(Matcher matcher, int i3) {
        return ((Long.parseLong(matcher.group(i3 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i3 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i3 + 3)) * 1000) + Long.parseLong(matcher.group(i3 + 4))) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public SubripSubtitle decode(byte[] bArr, int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i3);
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = parsableByteArray.readLine();
                    if (readLine2 == null) {
                        Log.w(TAG, "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine2);
                    if (matcher.matches()) {
                        boolean z17 = true;
                        longArray.add(parseTimecode(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            z17 = false;
                        } else {
                            longArray.add(parseTimecode(matcher, 6));
                        }
                        this.textBuilder.setLength(0);
                        while (true) {
                            String readLine3 = parsableByteArray.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(readLine3.trim());
                        }
                        arrayList.add(new Cue(Html.fromHtml(this.textBuilder.toString())));
                        if (z17) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w(TAG, "Skipping invalid timing: " + readLine2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Skipping invalid index: " + readLine);
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SubripSubtitle(cueArr, longArray.toArray());
    }
}
