package cooperation.qqcircle.helpers;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleIniFile {
    private String lineSeparator = null;
    private String charSet = "UTF-8";
    private Map<String, Section> sections = new LinkedHashMap();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Section {
        private String name;
        private Map<String, Object> values = new LinkedHashMap();

        public Object get(String str) {
            return this.values.get(str);
        }

        public String getName() {
            return this.name;
        }

        public Map<String, Object> getValues() {
            return this.values;
        }

        public void set(String str, Object obj) {
            this.values.put(str, obj);
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public QCircleIniFile() {
    }

    private void initFromInputStream(InputStream inputStream) {
        try {
            toIniFile(new BufferedReader(new InputStreamReader(inputStream, this.charSet)));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[Catch: IOException -> 0x0097, TryCatch #0 {IOException -> 0x0097, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0015, B:9:0x001f, B:11:0x0025, B:13:0x004c, B:14:0x0055, B:15:0x0061, B:17:0x0067, B:24:0x0089, B:20:0x008f, B:27:0x0052, B:29:0x0093), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveConfig(BufferedWriter bufferedWriter) {
        boolean z16;
        try {
            String str = this.lineSeparator;
            if (str != null && !str.trim().equals("")) {
                z16 = false;
                for (Section section : this.sections.values()) {
                    bufferedWriter.write("[" + section.getName() + "]");
                    if (z16) {
                        bufferedWriter.write(this.lineSeparator);
                    } else {
                        bufferedWriter.newLine();
                    }
                    for (Map.Entry<String, Object> entry : section.getValues().entrySet()) {
                        bufferedWriter.write(entry.getKey());
                        bufferedWriter.write(ContainerUtils.KEY_VALUE_DELIMITER);
                        bufferedWriter.write(entry.getValue().toString());
                        if (z16) {
                            bufferedWriter.write(this.lineSeparator);
                        } else {
                            bufferedWriter.newLine();
                        }
                    }
                }
                bufferedWriter.close();
            }
            z16 = true;
            while (r1.hasNext()) {
            }
            bufferedWriter.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private void toIniFile(BufferedReader bufferedReader) {
        Pattern compile = Pattern.compile("^\\[.*\\]$");
        Section section = null;
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (compile.matcher(readLine).matches()) {
                                String trim = readLine.trim();
                                Section section2 = new Section();
                                section2.name = trim.substring(1, trim.length() - 1);
                                this.sections.put(section2.name, section2);
                                section = section2;
                            } else {
                                String[] split = readLine.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                if (section != null && split != null && split.length == 2) {
                                    section.set(split[0], split[1]);
                                }
                            }
                        } else {
                            bufferedReader.close();
                            return;
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        bufferedReader.close();
                        return;
                    }
                } catch (Throwable th5) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
                return;
            }
        }
    }

    public Section get(String str) {
        return this.sections.get(str);
    }

    public void load(InputStream inputStream) {
        initFromInputStream(inputStream);
    }

    public void remove(String str) {
        this.sections.remove(str);
    }

    public void save(OutputStream outputStream) {
        try {
            saveConfig(new BufferedWriter(new OutputStreamWriter(outputStream, this.charSet)));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    public void set(String str, String str2, Object obj) {
        Section section = this.sections.get(str);
        if (section == null) {
            section = new Section();
        }
        section.name = str;
        section.set(str2, obj);
        this.sections.put(str, section);
    }

    public void setCharSet(String str) {
        this.charSet = str;
    }

    public void setLineSeparator(String str) {
        this.lineSeparator = str;
    }

    public Object get(String str, String str2) {
        return get(str, str2, null);
    }

    public void remove(String str, String str2) {
        Section section = this.sections.get(str);
        if (section != null) {
            section.getValues().remove(str2);
        }
    }

    public Object get(String str, String str2, String str3) {
        Section section = this.sections.get(str);
        if (section == null) {
            return null;
        }
        Object obj = section.get(str2);
        return (obj == null || obj.toString().trim().equals("")) ? str3 : obj;
    }

    public QCircleIniFile(InputStream inputStream) {
        initFromInputStream(inputStream);
    }
}
